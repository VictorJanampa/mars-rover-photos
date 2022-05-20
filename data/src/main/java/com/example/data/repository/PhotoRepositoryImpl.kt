package com.example.data.repository

import com.example.data.models.PhotoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoRepositoryImpl @Inject constructor() : PhotoRepository{
    private val dataExample = mutableListOf(PhotoEntity(
        102693,
        1000,
        "FHAZ",
        "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FLB_486265257EDR_F0481570FHAZ00323M_.JPG",
        "2015-05-30",
        "Curiosity"
    ),
        PhotoEntity(
            102694,
            1000,
            "FHAZ",
            "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FRB_486265257EDR_F0481570FHAZ00323M_.JPG",
            "2015-05-30",
            "Curiosity"
        ),)

    override suspend fun insertPhoto(photo: PhotoEntity) {

    }

    override fun getPhotos(): Flow<List<PhotoEntity>> = flow<List<PhotoEntity>> {
        emit(dataExample)
    }.flowOn(Dispatchers.IO)

}



