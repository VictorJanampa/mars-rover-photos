package com.example.domain.repository

import com.example.domain.models.Photo
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {
    suspend fun insertPhoto(photo: Photo)
    fun getPhotos(): Flow<List<Photo>>
    suspend fun cleanDatabase()
    suspend fun filterPhotos(cameraName: String)
}