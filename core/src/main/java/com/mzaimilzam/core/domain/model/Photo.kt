package com.mzaimilzam.core.domain.model

import androidx.room.ColumnInfo

data class Photo(
    val albumId: Int? = null,
    val id: Int? = null,
    val title: String? = null,
    val url: String? = null,
    val thumbnailUrl: String? = null
)
