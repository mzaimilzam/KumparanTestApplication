package com.mzaimilzam.kumparantestapplication.presenter.detail_photo

import com.mzaimilzam.core.domain.model.Comment

/**
 * Created by Muhammad Zaim Milzam on 08/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
data class DetailPhotoState(
    val isLoading: Boolean = false,
    val result: List<Comment> = emptyList(),
    val error: String = ""
)
