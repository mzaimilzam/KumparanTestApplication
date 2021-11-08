package com.mzaimilzam.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comment_entity")
data class CommentEntity(
    @ColumnInfo(name = "name")
    val name: String? = null,

    @ColumnInfo(name = "postId")
    val postId: Int? = null,

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int? = null,

    @ColumnInfo(name = "body")
    val body: String? = null,

    @ColumnInfo(name = "email")
    val email: String? = null
)