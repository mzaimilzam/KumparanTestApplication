package com.mzaimilzam.core.data.source.remote.network

import com.mzaimilzam.core.data.source.remote.response.album.AlbumsResponse
import com.mzaimilzam.core.data.source.remote.response.allpost.AllPostResponse
import com.mzaimilzam.core.data.source.remote.response.comment.CommentResponse
import com.mzaimilzam.core.data.source.remote.response.photo.PhotoResponse
import com.mzaimilzam.core.data.source.remote.response.users.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Muhammad Zaim Milzam on 04/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
interface ApiService {

    @GET("posts")
    suspend fun getAllPost(): List<AllPostResponse>

    @GET("users")
    suspend fun getUsers(): List<UsersResponse>

    @GET("comments")
    suspend fun getComments(
        @Query("postId") postId: Int
    ): List<CommentResponse>

    @GET("users/{userId}/albums")
    suspend fun getAlbumsbyUserId(
        @Path("userId") userId: Int
    ): List<AlbumsResponse>

    @GET("albums/{albumId}/photos")
    suspend fun getPhotobyAlbumId(
        @Path("albumId") albumId: Int
    ): List<PhotoResponse>
}