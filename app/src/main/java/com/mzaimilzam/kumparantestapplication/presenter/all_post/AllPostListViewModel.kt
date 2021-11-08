package com.mzaimilzam.kumparantestapplication.presenter.all_post

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mzaimilzam.core.data.Resource
import com.mzaimilzam.core.domain.usecase.IAllPostUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Muhammad Zaim Milzam on 05/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
@HiltViewModel
class AllPostListViewModel @Inject constructor(
    private val allPostUseCase: IAllPostUsecase,
) : ViewModel() {

    private val _state = mutableStateOf(AllPostListState())
    val state: State<AllPostListState> = _state

    init {
        getAllPost()
    }

    private fun getAllPost() {
        allPostUseCase.getAllpost().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = AllPostListState(isLoading = true)
                }
                is Resource.Success -> {
                    getUsers()
                }
                is Resource.Error -> {
                    _state.value = AllPostListState(
                        isLoading = false,
                        error = result.message ?: "An Expected error occured.",
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getUsers() {
        allPostUseCase.getAllUsers().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = AllPostListState(isLoading = true)
                }
                is Resource.Success -> {
                    resultALlPost()
                }
                is Resource.Error -> {
                    _state.value = AllPostListState(
                        isLoading = false,
                        error = result.message ?: "An Expected error occured.",
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun resultALlPost() {
        allPostUseCase.getresultAllPost().onEach { result ->
            _state.value = AllPostListState(isLoading = false, result = result)
        }.launchIn(viewModelScope)
    }

}