package com.example.domain.interactors

interface FilterPhotosUseCase {
    suspend operator fun invoke(cameraName: String)
}