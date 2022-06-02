package com.example.domain.interactors


import com.example.domain.repository.PhotoRepository
import javax.inject.Inject

class FilterPhotosUseCaseImpl @Inject constructor(private val repository: PhotoRepository) : FilterPhotosUseCase {
    override suspend operator fun invoke(cameraName: String) {
        repository.cleanDatabase()
        repository.filterPhotos(cameraName)
    }
}