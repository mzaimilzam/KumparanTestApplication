package com.mzaimilzam.core.data.source

import com.mzaimilzam.core.data.NetworkBoundResource
import com.mzaimilzam.core.data.Resource
import com.mzaimilzam.core.data.source.local.room.LocalDataSource
import com.mzaimilzam.core.data.source.remote.ApiResponse
import com.mzaimilzam.core.data.source.remote.RemoteDataSource
import com.mzaimilzam.core.data.source.remote.response.album.AlbumsResponse
import com.mzaimilzam.core.data.source.remote.response.allpost.AllPostResponse
import com.mzaimilzam.core.data.source.remote.response.comment.CommentResponse
import com.mzaimilzam.core.data.source.remote.response.photo.PhotoResponse
import com.mzaimilzam.core.data.source.remote.response.users.UsersResponse
import com.mzaimilzam.core.domain.model.*
import com.mzaimilzam.core.domain.repository.IRepository
import com.mzaimilzam.core.utils.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 04/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
@Singleton
class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IRepository {

    override fun getAllpost(): Flow<Resource<List<AllPost>>> =
        object : NetworkBoundResource<List<AllPost>, List<AllPostResponse>>() {
            override fun loadFromDB(): Flow<List<AllPost>> {
                return localDataSource.getALllPost().map {
                    DataMapperAllPost.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<AllPost>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<AllPostResponse>>> =
                remoteDataSource.getAllPost()

            override suspend fun saveCallResult(data: List<AllPostResponse>) {
                val list = DataMapperAllPost.mapResponsetoEntity(data)
                localDataSource.insertAndDeleteALlPost(list)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteAllPost()
            }

        }.asFlow()

    override fun getUsers(): Flow<Resource<List<Users>>> =
        object : NetworkBoundResource<List<Users>, List<UsersResponse>>() {
            override fun loadFromDB(): Flow<List<Users>> {
                return localDataSource.getUsers().map {
                    DataMapperUsers.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<Users>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<UsersResponse>>> =
                remoteDataSource.getUsers()

            override suspend fun saveCallResult(data: List<UsersResponse>) {
                val list = DataMapperUsers.mapResponsetoEntity(data)
                localDataSource.insertAndDeleteUsers(list)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteUsers()
            }

        }.asFlow()

    override fun getresultAllPost(): Flow<List<ResultListAllPost>> {
        return localDataSource.getResultALlPost()
            .map { DataMapperResultAllPost.mapEntitiestoDomain(it) }
    }

    override fun getComments(postId: Int): Flow<Resource<List<Comment>>> =
        object : NetworkBoundResource<List<Comment>, List<CommentResponse>>() {
            override fun loadFromDB(): Flow<List<Comment>> {
                return localDataSource.getComments().map {
                    DataMapperComment.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<Comment>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<CommentResponse>>> =
                remoteDataSource.getComments(postId)

            override suspend fun saveCallResult(data: List<CommentResponse>) {
                val list = DataMapperComment.mapResponsetoEntity(data)
                localDataSource.insertAndDeleteComments(list)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteComments()
            }

        }.asFlow()

    override fun getUsersbyId(userId: String): Flow<Users> {
        return localDataSource.getUsersbyId(userid = userId.toInt())
            .map { DataMapperUsers.mapSingleEntitiestoDomain(it) }
    }


    override fun getAlbumsbyUserId(userId: Int): Flow<Resource<List<Albums>>> =
        object : NetworkBoundResource<List<Albums>, List<AlbumsResponse>>() {
            override fun loadFromDB(): Flow<List<Albums>> {
                return localDataSource.getAlbums().map {
                    DataMapperAlbums.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<Albums>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<AlbumsResponse>>> =
                remoteDataSource.getAlbumsbyUserId(userId)

            override suspend fun saveCallResult(data: List<AlbumsResponse>) {
                val list = DataMapperAlbums.mapResponsetoEntity(data)
                localDataSource.insertAndDeleteAlbums(list)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteAlbums()
            }

        }.asFlow()

    override fun getPhotobyAlbumId(albumId: Int): Flow<Resource<List<Photo>>> =
        object : NetworkBoundResource<List<Photo>, List<PhotoResponse>>() {
            override fun loadFromDB(): Flow<List<Photo>> {
                return localDataSource.getPhoto().map {
                    DataMapperPhoto.mapEntitiestoDomain(it)
                }
            }

            override fun shouldFetch(data: List<Photo>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<PhotoResponse>>> =
                remoteDataSource.getPhotobyAlbumId(albumId)

            override suspend fun saveCallResult(data: List<PhotoResponse>) {
                val list = DataMapperPhoto.mapResponsetoEntity(data)
                localDataSource.insertPhoto(list)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deletePhoto()
            }

        }.asFlow()

    override suspend fun deletePhoto() {
        return localDataSource.deletePhoto()
    }

    override fun getFilterFoto(albumId: Int): Flow<List<Photo>> {
        return localDataSource.getFilterPhoto(albumId)
            .map { DataMapperPhoto.mapEntitiestoDomain(it) }
    }


}

