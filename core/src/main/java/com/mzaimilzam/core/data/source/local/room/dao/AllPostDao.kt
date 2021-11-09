package com.mzaimilzam.core.data.source.local.room.dao

import androidx.room.*
import com.mzaimilzam.core.data.source.local.entity.*
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 04/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
@Dao
interface AllPostDao {

    // List AllPost
    @Query("SELECT * FROM all_post_entity")
    fun getAllPost(): Flow<List<AllPostEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPost(users: List<AllPostEntity>)

    @Query("DELETE FROM all_post_entity")
    suspend fun deleteAllPost()

    @Transaction
    suspend fun insertAndDeleteALlPost(users: List<AllPostEntity>) {
        deleteAllPost()
        insertAllPost(users)
    }

    // Users
    @Query("SELECT * FROM user_entity")
    fun getUsers(): Flow<List<UsersEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UsersEntity>)

    @Query("DELETE FROM user_entity")
    suspend fun deleteUsers()

    @Transaction
    suspend fun insertAndDeleteUsers(users: List<UsersEntity>) {
        deleteUsers()
        insertUsers(users)
    }

    @Query("SELECT * FROM user_entity WHERE id LIKE '%'|| :userId || '%' ")
    fun getUsersbyId(userId: Int): Flow<UsersEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsersbyId(users: UsersEntity)

    @Transaction
    suspend fun insertAndDeleteUsersbyId(users: UsersEntity) {
        deleteUsers()
        insertUsersbyId(users)
    }

    // Result All Post
    @Query("SELECT all_post_entity.id AS id, all_post_entity.title AS title, all_post_entity.body AS body, all_post_entity.userId AS userId, user_entity.username AS username, user_entity.company_name AS company_name From all_post_entity LEFT JOIN user_entity ON all_post_entity.userId = user_entity.id")
    fun getResultAllPost(): Flow<List<ResultListAllPostEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResultAAllpost(allpost: List<ResultListAllPostEntity>)

    @Query("DELETE FROM result_allpost_entity")
    suspend fun deleteResultAllPost()

    @Transaction
    suspend fun insertAndDeleteresultALlPost(resultAllpost: List<ResultListAllPostEntity>) {
        deleteResultAllPost()
        insertAndDeleteresultALlPost(resultAllpost)
    }

    // Comments
    @Query("SELECT * FROM comment_entity")
    fun getComments(): Flow<List<CommentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComments(users: List<CommentEntity>)

    @Query("DELETE FROM comment_entity")
    suspend fun deleteComments()

    @Transaction
    suspend fun insertAndDeleteComments(data: List<CommentEntity>) {
        deleteComments()
        insertComments(data)
    }

    // Albums
    @Query("SELECT * FROM albums_entity")
    fun getAlbums(): Flow<List<AlbumsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlbums(users: List<AlbumsEntity>)

    @Query("DELETE FROM albums_entity")
    suspend fun deleteAlbums()

    @Transaction
    suspend fun insertAndDeleteAlbums(data: List<AlbumsEntity>) {
        deleteAlbums()
        insertAlbums(data)
    }

    // Albums
    @Query("SELECT * FROM photo_entity")
    fun getPhoto(): Flow<List<PhotoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhoto(users: List<PhotoEntity>)

    @Query("DELETE FROM photo_entity")
    suspend fun deletePhoto()

    @Transaction
    suspend fun insertAndDeletePhoto(data: List<PhotoEntity>) {
        deletePhoto()
        insertPhoto(data)
    }

    @Query("SELECT photo_entity.id AS id,  photo_entity.title AS title, photo_entity.url AS url,photo_entity.thumbnailUrl AS thumbnailUrl, photo_entity.albumId AS albumId , albums_entity.title AS albumName FROM photo_entity LEFT JOIN albums_entity ON photo_entity.albumId = albums_entity.id")
    fun getResultAlbumList(): Flow<List<ResultAlbumListEntity>>
}