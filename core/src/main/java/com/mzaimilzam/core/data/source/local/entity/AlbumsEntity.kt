package com.mzaimilzam.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albums_entity")
data class AlbumsEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int? = null,

    @ColumnInfo(name ="title")
    val title: String? = null,

    @ColumnInfo(name ="userId")
    val userId: Int? = null
)