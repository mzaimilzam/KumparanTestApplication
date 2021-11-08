package com.mzaimilzam.kumparantestapplication.presenter.detail_user

import com.mzaimilzam.core.domain.model.Albums
import com.mzaimilzam.core.domain.model.Photo
import com.mzaimilzam.core.domain.model.Users

/**
 * Created by Muhammad Zaim Milzam on 08/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
data class DetailUserState(
    val isLoading: Boolean = false,
    val result: Users? = null,
    val error: String = ""
)

data class DetailAlbumsState(
    val isLoading: Boolean = false,
    val result: List<Albums> = emptyList(),
    val error: String = ""
)

data class DetailPhotoState(
    val isLoading: Boolean = false,
    val result: List<Photo> = emptyList(),
    val error: String = ""
)
