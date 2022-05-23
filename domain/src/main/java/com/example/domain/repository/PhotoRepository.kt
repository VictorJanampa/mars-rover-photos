package com.example.domain.repository

import kotlinx.coroutines.flow.Flow

interface PhotoRepository<T: Any> {
    suspend fun insertPhoto(photo: T)
    suspend fun getPhotos(): Flow<List<T>>
}