package com.mzaimilzam.core.utils

import com.mzaimilzam.core.data.source.local.entity.PhotoEntity
import com.mzaimilzam.core.data.source.remote.response.photo.PhotoResponse
import com.mzaimilzam.core.domain.model.Photo

/**
 * Created by Muhammad Zaim Milzam on 04/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperPhoto {

    fun mapResponsetoEntity(input: List<PhotoResponse>): List<PhotoEntity> {
        val list = ArrayList<PhotoEntity>()
        input.map {
            val response = PhotoEntity(
                id = it.id,
                title = it.title,
                albumId = it.albumId,
                url = it.url,
                thumbnailUrl = it.thumbnailUrl
            )
            list.add(response)
        }
        return list
    }

    fun mapEntitiestoDomain(input: List<PhotoEntity>): List<Photo> =
        input.map {
            Photo(
                id = it.id,
                title = it.title,
                albumId = it.albumId,
                url = it.url,
                thumbnailUrl = it.thumbnailUrl
            )
        }

}