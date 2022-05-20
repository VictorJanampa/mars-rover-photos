package com.example.data.repository

import com.example.data.models.PhotoEntity
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {
    suspend fun insertPhoto(photo: PhotoEntity)
    fun getPhotos(): Flow<List<PhotoEntity>>
}