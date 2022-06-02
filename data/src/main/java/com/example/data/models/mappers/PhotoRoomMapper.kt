package com.example.data.models.mappers

import com.example.data.models.PhotoRoomModel
import com.example.domain.models.Photo

class PhotoRoomMapper{
    companion object{
        private fun mapToDomainModel(roomModel: PhotoRoomModel): Photo {
            return Photo(
                roomModel.id,
                roomModel.sol,
                roomModel.camera,
                roomModel.imgSrc,
                roomModel.earthDate,
                roomModel.rover,
            )
        }

        fun mapToRoomModel(domainModel: Photo): PhotoRoomModel {
            return PhotoRoomModel(
                domainModel.id,
                domainModel.sol,
                domainModel.cameraName,
                domainModel.imgSrc,
                domainModel.earthDate,
                domainModel.roverName,
            )
        }

        fun mapToDomainModelList(list: List<PhotoRoomModel>): List<Photo> {
            return list.map { mapToDomainModel(it) }
        }
    }
}