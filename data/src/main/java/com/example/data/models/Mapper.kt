package com.example.data.models

import com.example.domain.models.Photo

interface Mapper<T:Any, R : Any> {
    fun mapToRoomModel(networkModel: T): R
    //fun mapToDomainModel(roomModel: T): R
}

