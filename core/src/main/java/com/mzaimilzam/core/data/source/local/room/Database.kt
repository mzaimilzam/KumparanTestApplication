package com.mzaimilzam.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mzaimilzam.core.data.source.local.entity.*
import com.mzaimilzam.core.data.source.local.room.dao.AllPostDao
import com.mzaimilzam.core.utils.Constant.DATABASE_VERSION

/**
 * Created by Muhammad Zaim Milzam on 04/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
@Database(
    entities = [
        AllPostEntity::class,
        UsersEntity::class,
        ResultListAllPostEntity::class,
        CommentEntity::class,
        AlbumsEntity::class,
        PhotoEntity::class,
        ResultAlbumListEntity::class
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class Database : RoomDatabase() {

    abstract fun allPostDao(): AllPostDao
}