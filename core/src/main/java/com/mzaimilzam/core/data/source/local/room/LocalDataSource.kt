package com.mzaimilzam.core.data.source.local.room

import com.mzaimilzam.core.data.source.local.entity.*
import com.mzaimilzam.core.data.source.local.room.dao.AllPostDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 04/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
@Singleton
class LocalDataSource @Inject constructor(
    private val allPostDao: AllPostDao
) {
    /** All Post Page **/
    // allpost
    fun getALllPost(): Flow<List<AllPostEntity>> = allPostDao.getAllPost()

    suspend fun insertAndDeleteALlPost(allPost: List<AllPostEntity>) =
        allPostDao.insertAndDeleteALlPost(allPost)

    suspend fun deleteAllPost() = allPostDao.deleteAllPost()

    // users
    fun getUsers(): Flow<List<UsersEntity>> = allPostDao.getUsers()

    suspend fun insertAndDeleteUsers(users: List<UsersEntity>) =
        allPostDao.insertAndDeleteUsers(users)

    suspend fun deleteUsers() = allPostDao.deleteUsers()

    fun getUsersbyId(userid: Int): Flow<UsersEntity> = allPostDao.getUsersbyId(userid)

    suspend fun insertAndDeleteUsersbyId(users: UsersEntity) =
        allPostDao.insertAndDeleteUsersbyId(users)

    // result ALl Post
    fun getResultALlPost(): Flow<List<ResultListAllPostEntity>> = allPostDao.getResultAllPost()

    suspend fun insertAndDeleteResultAllPost(users: List<ResultListAllPostEntity>) =
        allPostDao.insertAndDeleteresultALlPost(users)

    suspend fun deleteResultAllPost() = allPostDao.deleteResultAllPost()

    /** Detail Post Page **/
    // getComments
    fun getComments(): Flow<List<CommentEntity>> = allPostDao.getComments()

    suspend fun insertAndDeleteComments(data: List<CommentEntity>) =
        allPostDao.insertAndDeleteComments(data)

    suspend fun deleteComments() = allPostDao.deleteComments()

    /** Detail User Page **/

    // getAlbums
    fun getAlbums(): Flow<List<AlbumsEntity>> = allPostDao.getAlbums()

    suspend fun insertAndDeleteAlbums(data: List<AlbumsEntity>) =
        allPostDao.insertAndDeleteAlbums(data)

    suspend fun deleteAlbums() = allPostDao.deleteAlbums()

    // getPhoto
    fun getPhoto(): Flow<List<PhotoEntity>> = allPostDao.getPhoto()

    suspend fun insertPhoto(data: List<PhotoEntity>) =
        allPostDao.insertPhoto(data)

    suspend fun deletePhoto() = allPostDao.deletePhoto()


    // result AlbumLIst
    fun getResultALbumList() = allPostDao.getResultAlbumList()
}