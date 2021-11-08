package com.mzaimilzam.core.utils

import com.mzaimilzam.core.data.source.local.entity.AllPostEntity
import com.mzaimilzam.core.data.source.remote.response.allpost.AllPostResponse
import com.mzaimilzam.core.domain.model.AllPost

/**
 * Created by Muhammad Zaim Milzam on 04/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperAllPost {

    fun mapResponsetoEntity(input: List<AllPostResponse>): List<AllPostEntity> {
        val list = ArrayList<AllPostEntity>()
        input.map {
            val response = AllPostEntity(
                id = it.id,
                title = it.title,
                body = it.body,
                userId = it.userId
            )
            list.add(response)
        }
        return list
    }

    fun mapEntitiestoDomain(input: List<AllPostEntity>): List<AllPost> =
        input.map {
            AllPost(
                id = it.id,
                title = it.title,
                body = it.body,
                userId = it.userId
            )
        }

}