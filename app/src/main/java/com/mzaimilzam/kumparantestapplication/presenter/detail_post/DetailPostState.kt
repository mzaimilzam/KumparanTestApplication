package com.mzaimilzam.kumparantestapplication.presenter.detail_post

import com.mzaimilzam.core.domain.model.Comment

/**
 * Created by Muhammad Zaim Milzam on 06/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
data class DetailPostState(
    val isLoading: Boolean = false,
    val result: List<Comment> = emptyList(),
    val error: String = ""
)
