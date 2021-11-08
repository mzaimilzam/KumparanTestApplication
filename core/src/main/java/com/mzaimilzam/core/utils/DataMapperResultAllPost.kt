package com.mzaimilzam.core.utils

import com.mzaimilzam.core.data.source.local.entity.ResultListAllPostEntity
import com.mzaimilzam.core.domain.model.ResultListAllPost

/**
 * Created by Muhammad Zaim Milzam on 04/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperResultAllPost {

    fun mapEntitiestoDomain(input: List<ResultListAllPostEntity>): List<ResultListAllPost> =
        input.map {
            ResultListAllPost(
                title = it.title,
                body = it.body,
                userId = it.userId,
                companyName = it.companyName,
                id = it.id,
                username = it.username
            )
        }
}