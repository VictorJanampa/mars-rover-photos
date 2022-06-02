package com.example.data.repository

import android.util.Log
import com.example.data.database.PhotoDatabaseDao
import com.example.data.models.mappers.PhotoNetworkMapper
import com.example.data.models.mappers.PhotoRoomMapper
import com.example.data.network.PhotoApiService
import com.example.domain.models.Photo
import com.example.domain.repository.PhotoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoRepositoryImpl @Inject constructor(
    private val api: PhotoApiService,
    private val database: PhotoDatabaseDao
    ) : PhotoRepository {

    override suspend fun insertPhoto(photo: Photo) {
        database.insertPhoto(PhotoRoomMapper.mapToRoomModel(photo))
    }

    override fun getPhotos(): Flow<List<Photo>> {
        val photosFlow = database.getAllPhotos().flowOn(Dispatchers.IO)
        CoroutineScope(Dispatchers.IO).launch {
            if (photosFlow.first().isEmpty()) {
                database.insertAllPhotos(PhotoNetworkMapper.mapToRoomModelList(api.getPhotos(1000).photos))
            }
        }
        return photosFlow.map { PhotoRoomMapper.mapToDomainModelList(it) }
    }

    override suspend fun cleanDatabase() {
        database.clearPhotos()
    }

    override suspend fun filterPhotos(cameraName: String) {
        database.insertAllPhotos(PhotoNetworkMapper.mapToRoomModelList(api.getFilteredPhotos(1000,cameraName = cameraName).photos))
    }
}



