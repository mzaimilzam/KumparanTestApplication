package com.mzaimilzam.core.data.source.remote

import com.mzaimilzam.core.data.source.remote.network.ApiService
import com.mzaimilzam.core.data.source.remote.response.album.AlbumsResponse
import com.mzaimilzam.core.data.source.remote.response.allpost.AllPostResponse
import com.mzaimilzam.core.data.source.remote.response.comment.CommentResponse
import com.mzaimilzam.core.data.source.remote.response.photo.PhotoResponse
import com.mzaimilzam.core.data.source.remote.response.users.UsersResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 04/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */

@Singleton
class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getAllPost(): Flow<ApiResponse<List<AllPostResponse>>> {
        return flow {
            try {
                val response = apiService.getAllPost()
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }

        }.flowOn(Dispatchers.IO)
    }

    suspend fun getUsers(): Flow<ApiResponse<List<UsersResponse>>> {
        return flow {
            try {
                val response = apiService.getUsers()
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }

        }.flowOn(Dispatchers.IO)
    }

    suspend fun getComments(postId: Int): Flow<ApiResponse<List<CommentResponse>>> {
        return flow {
            try {
                val response = apiService.getComments(postId)
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }

        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAlbumsbyUserId(userId: Int): Flow<ApiResponse<List<AlbumsResponse>>> {
        return flow {
            try {
                val response = apiService.getAlbumsbyUserId(userId)
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }

        }.flowOn(Dispatchers.IO)
    }

    suspend fun getPhotobyAlbumId(albumId: Int): Flow<ApiResponse<List<PhotoResponse>>> {
        return flow {
            try {
                val response = apiService.getPhotobyAlbumId(albumId)
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }

        }.flowOn(Dispatchers.IO)
    }
}