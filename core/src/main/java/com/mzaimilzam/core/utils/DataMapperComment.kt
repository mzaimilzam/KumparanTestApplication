package com.mzaimilzam.core.utils

import com.mzaimilzam.core.data.source.local.entity.CommentEntity
import com.mzaimilzam.core.data.source.remote.response.comment.CommentResponse
import com.mzaimilzam.core.domain.model.Comment

/**
 * Created by Muhammad Zaim Milzam on 04/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperComment {

    fun mapResponsetoEntity(input: List<CommentResponse>): List<CommentEntity> {
        val list = ArrayList<CommentEntity>()
        input.map {
            val response = CommentEntity(
                id = it.id,
                postId = it.postId,
                body = it.body,
                name = it.name,
                email = it.email
            )
            list.add(response)
        }
        return list
    }

    fun mapEntitiestoDomain(input: List<CommentEntity>): List<Comment> =
        input.map {
            Comment(
                id = it.id,
                postId = it.postId,
                body = it.body,
                name = it.name,
                email = it.email
            )
        }

}