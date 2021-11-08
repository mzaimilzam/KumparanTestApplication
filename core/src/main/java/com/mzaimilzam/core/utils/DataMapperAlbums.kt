package com.mzaimilzam.core.utils

import com.mzaimilzam.core.data.source.local.entity.AlbumsEntity
import com.mzaimilzam.core.data.source.remote.response.album.AlbumsResponse
import com.mzaimilzam.core.domain.model.Albums

/**
 * Created by Muhammad Zaim Milzam on 04/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperAlbums {

    fun mapResponsetoEntity(input: List<AlbumsResponse>): List<AlbumsEntity> {
        val list = ArrayList<AlbumsEntity>()
        input.map {
            val response = AlbumsEntity(
                id = it.id,
                title = it.title,
                userId = it.userId
            )
            list.add(response)
        }
        return list
    }

    fun mapEntitiestoDomain(input: List<AlbumsEntity>): List<Albums> =
        input.map {
            Albums(
                id = it.id,
                title = it.title,
                userId = it.userId
            )
        }

}