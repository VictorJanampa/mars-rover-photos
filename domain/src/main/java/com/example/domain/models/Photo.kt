package com.example.domain.models

data class Photo(
    val id: Long,
    val sol: Int,
    val cameraName: String,
    val imgSrc: String,
    val earthDate: String,
    val roverName: String
)
