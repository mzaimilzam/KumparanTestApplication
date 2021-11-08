package com.mzaimilzam.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Muhammad Zaim Milzam on 05/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
@Entity(tableName = "result_allpost_entity")
data class ResultListAllPostEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int? = null,

    @ColumnInfo(name = "title")
    val title: String? = null,

    @ColumnInfo(name = "body")
    val body: String? = null,

    @ColumnInfo(name = "userId")
    val userId: Int? = null,

    @ColumnInfo(name = "company_name")
    val companyName: String? = null,

    @ColumnInfo(name ="username")
    val username: String? = null,

)
