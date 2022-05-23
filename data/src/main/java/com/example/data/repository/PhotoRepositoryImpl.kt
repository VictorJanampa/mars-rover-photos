package com.example.data.repository

import android.util.Log
import com.example.data.database.PhotoDatabaseDao
import com.example.data.models.PhotoNetworkMapper
import com.example.data.models.PhotoRoomModel
import com.example.data.network.PhotoApiService
import com.example.domain.repository.PhotoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoRepositoryImpl @Inject constructor(private val api: PhotoApiService, private val database: PhotoDatabaseDao) : PhotoRepository<PhotoRoomModel> {
    private val dataExample = mutableListOf(PhotoRoomModel(
        102693,
        1000,
        "FHAZ",
        "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FLB_486265257EDR_F0481570FHAZ00323M_.JPG",
        "2015-05-30",
        "Curiosity"
    ),
        PhotoRoomModel(
            102694,
            1000,
            "FHAZ",
            "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FRB_486265257EDR_F0481570FHAZ00323M_.JPG",
            "2015-05-30",
            "Curiosity"
        ),)
    private val mapper = PhotoNetworkMapper()

    override suspend fun insertPhoto(photo: PhotoRoomModel) {

    }

    override suspend fun getPhotos(): Flow<List<PhotoRoomModel>> {
        val photosFlow = database.getAllPhotos()
        withContext(Dispatchers.IO){
            try {
                if (photosFlow.first().isEmpty()) {
                    database.insertAllPhotos(mapper.mapToRoomModelList(api.getPhotos(1000).photos))
                }else{}
            } catch (e: Exception) {
                Log.wtf("On getPhotos",e.message)
            }
        }
        return photosFlow
    }
}



