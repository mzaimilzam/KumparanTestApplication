package com.mzaimilzam.kumparantestapplication.presenter.all_post

import com.mzaimilzam.core.domain.model.ResultListAllPost

/**
 * Created by Muhammad Zaim Milzam on 05/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
data class AllPostListState(
    val isLoading: Boolean = false,
    val result: List<ResultListAllPost> = emptyList(),
    val error: String = ""
)
