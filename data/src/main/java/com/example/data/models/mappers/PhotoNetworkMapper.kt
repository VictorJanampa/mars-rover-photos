package com.example.data.models.mappers

import com.example.data.models.PhotoNetworkModel
import com.example.data.models.PhotoRoomModel

class PhotoNetworkMapper {

    companion object{
        private fun mapToRoomModel(networkModel: PhotoNetworkModel): PhotoRoomModel {
            return PhotoRoomModel(
                networkModel.id,
                networkModel.sol,
                networkModel.camera.name,
                networkModel.img_src,
                networkModel.earth_date,
                networkModel.rover.name,
            )
        }

        fun mapToRoomModelList(list: List<PhotoNetworkModel>): List<PhotoRoomModel> {
            return list.map { mapToRoomModel(it) }
        }
    }

}