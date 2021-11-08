package com.mzaimilzam.core.utils

import com.mzaimilzam.core.data.source.local.entity.UsersEntity
import com.mzaimilzam.core.data.source.remote.response.users.UsersResponse
import com.mzaimilzam.core.domain.model.Users

/**
 * Created by Muhammad Zaim Milzam on 04/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperUsers {

    fun mapResponsetoEntity(input: List<UsersResponse>): List<UsersEntity> {
        val list = ArrayList<UsersEntity>()
        input.map {
            val response = UsersEntity(
                website = it.website,
                address = it.address?.street,
                phone = it.phone,
                name = it.name,
                companyName = it.company?.name,
                id = it.id,
                email = it.email,
                username = it.username

            )
            list.add(response)
        }
        return list
    }

    fun mapEntitiestoDomain(input: List<UsersEntity>): List<Users> =
        input.map {
            Users(
                website = it.website,
                address = it.address,
                phone = it.phone,
                name = it.name,
                companyName = it.companyName,
                id = it.id,
                email = it.email,
                username = it.username
            )
        }
    fun mapSingleEntitiestoDomain(it: UsersEntity): Users =
        Users(
            website = it.website,
            address = it.address,
            phone = it.phone,
            name = it.name,
            companyName = it.companyName,
            id = it.id,
            email = it.email,
            username = it.username
        )

}