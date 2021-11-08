package com.mzaimilzam.kumparantestapplication.presenter.detail_post

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mzaimilzam.core.data.Resource
import com.mzaimilzam.core.domain.usecase.IAllPostUsecase
import com.mzaimilzam.kumparantestapplication.DETAIL_SCREEN_POSTID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Muhammad Zaim Milzam on 06/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */

@HiltViewModel
class DetailPostViewModel @Inject constructor(
    private val usecase: IAllPostUsecase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(DetailPostState())
    val state: State<DetailPostState> = _state

    init {
        savedStateHandle.get<String>(DETAIL_SCREEN_POSTID)?.let { postId ->
            getComments(postId = postId.toInt())
        }
    }

    fun getComments(postId: Int) {
        usecase.getComments(postId = postId).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = DetailPostState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value =
                        DetailPostState(isLoading = false, result = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = DetailPostState(
                        isLoading = false,
                        error = result.message ?: "An Expected error occured.",
                    )
                }
            }
        }.launchIn(viewModelScope)

    }
}