package com.example.domain.interactors

import com.example.domain.models.Photo
import kotlinx.coroutines.flow.Flow

interface GetPhotosUseCase {
    operator fun invoke(): Flow<List<Photo>>
}