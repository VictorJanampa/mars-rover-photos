package com.example.domain.interactors

import com.example.domain.models.Photo
import com.example.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPhotosUseCaseImpl @Inject constructor(private val repository: PhotoRepository) : GetPhotosUseCase {
    override operator fun invoke(): Flow<List<Photo>> = repository.getPhotos()
}
