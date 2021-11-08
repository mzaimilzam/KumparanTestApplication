package com.mzaimilzam.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "all_post_entity")
data class AllPostEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int? = null,

    @ColumnInfo(name = "title")
    val title: String? = null,

    @ColumnInfo(name = "body")
    val body: String? = null,

    @ColumnInfo(name = "userId")
    val userId: Int? = null
)
