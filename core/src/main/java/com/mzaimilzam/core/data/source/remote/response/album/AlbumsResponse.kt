package com.mzaimilzam.core.data.source.remote.response.album

import com.google.gson.annotations.SerializedName

data class AlbumsResponse(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("userId")
    val userId: Int? = null
)