package com.mzaimilzam.core.domain.repository

import com.mzaimilzam.core.data.Resource
import com.mzaimilzam.core.domain.model.*
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 04/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
interface IRepository {

    fun getAllpost(): Flow<Resource<List<AllPost>>>
    fun getUsers(): Flow<Resource<List<Users>>>
    fun getresultAllPost(): Flow<List<ResultListAllPost>>

    // detail post
    fun getComments(postId: Int): Flow<Resource<List<Comment>>>

    // user detail
    fun getUsersbyId(userId: String): Flow<Users>
    fun getAlbumsbyUserId(userId: Int): Flow<Resource<List<Albums>>>
    fun getPhotobyAlbumId(albumId: Int): Flow<Resource<List<Photo>>>
    suspend fun deletePhoto()

    fun getResultAlbumList(): Flow<List<ResultAlbumList>>

}