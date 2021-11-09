package com.mzaimilzam.core.domain.usecase

import com.mzaimilzam.core.data.Resource
import com.mzaimilzam.core.data.source.Repository
import com.mzaimilzam.core.domain.model.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Muhammad Zaim Milzam on 04/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
class AllPostInteractor @Inject constructor(private val repository: Repository) : IAllPostUsecase {

    override fun getAllpost(): Flow<Resource<List<AllPost>>> = repository.getAllpost()
    override fun getAllUsers(): Flow<Resource<List<Users>>> = repository.getUsers()
    override fun getresultAllPost(): Flow<List<ResultListAllPost>> = repository.getresultAllPost()
    override fun getComments(postId: Int): Flow<Resource<List<Comment>>> =
        repository.getComments(postId)

    override fun getUsersbyId(userId: String): Flow<Users> =
        repository.getUsersbyId(userId)

    override fun getAlbumsbyUserId(userId: Int): Flow<Resource<List<Albums>>> =
        repository.getAlbumsbyUserId(userId)

    override fun getPhotobyAlbumId(albumId: Int): Flow<Resource<List<Photo>>> =
        repository.getPhotobyAlbumId(albumId)

    override suspend fun deletePhoto() = repository.deletePhoto()
    override fun getResultAlbumList(): Flow<List<ResultAlbumList>> = repository.getResultAlbumList()
}