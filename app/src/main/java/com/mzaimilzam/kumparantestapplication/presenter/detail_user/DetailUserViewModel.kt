package com.mzaimilzam.kumparantestapplication.presenter.detail_user

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mzaimilzam.core.data.Resource
import com.mzaimilzam.core.domain.usecase.IAllPostUsecase
import com.mzaimilzam.kumparantestapplication.DETAIL_USER_SCREEN_USERID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Muhammad Zaim Milzam on 06/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */

@HiltViewModel
class DetailUserViewModel @Inject constructor(
    private val usecase: IAllPostUsecase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(DetailUserState())
    val state: State<DetailUserState> = _state

    private val _stateAlbums = mutableStateOf(DetailAlbumsState())
    val stateAlbums: State<DetailAlbumsState> = _stateAlbums

    private val _stateResult = mutableStateOf(DetailResultState())
    val stateResult: State<DetailResultState> = _stateResult

    init {
        viewModelScope.launch {
            deletePhoto()
        }
        savedStateHandle.get<String>(DETAIL_USER_SCREEN_USERID)?.let { userId ->
            getUserById(userId = userId)
            getAlbums(userId = userId)
        }

    }

    suspend fun deletePhoto() {
        usecase.deletePhoto()
    }

    fun getUserById(userId: String) {
        usecase.getUsersbyId(userId = userId).onEach { result ->
            _state.value =
                DetailUserState(isLoading = false, result = result)
        }.launchIn(viewModelScope)

    }

    fun getAlbums(userId: String) {
        usecase.getAlbumsbyUserId(userId = userId.toInt()).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _stateAlbums.value = DetailAlbumsState(isLoading = true)
                }
                is Resource.Success -> {
                    for (i in 0 until result.data?.size!!) {
                        result.data!![i].id?.let { getPhotobyAlbumId(it) }
                    }
                    _stateAlbums.value =
                        DetailAlbumsState(isLoading = false, result = result.data ?: emptyList())

                }
                is Resource.Error -> {
                    _stateAlbums.value = DetailAlbumsState(
                        isLoading = false,
                        error = result.message ?: "An Expected error occured.",
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getPhotobyAlbumId(albumId: Int) {
        usecase.getPhotobyAlbumId(albumId).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _stateResult.value = DetailResultState(isLoading = true)
                }
                is Resource.Success -> {
                    resultAlbumList()
                }
                is Resource.Error -> {
                    _stateResult.value = DetailResultState(
                        isLoading = false,
                        error = result.message ?: "An Expected error occured.",
                    )
                }
            }

        }.launchIn(viewModelScope)
    }

    private fun resultAlbumList() {
        usecase.getResultAlbumList().onEach { result ->
            _stateResult.value = DetailResultState(isLoading = false, result = result)
        }.launchIn(viewModelScope)
    }

}