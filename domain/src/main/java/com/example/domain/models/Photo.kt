package com.example.domain.models

data class Photo(
    val id: Long,
    val sol: Int,
    val camera: Camera,
    val img_src: String,
    val earth_date: String,
    val rover: Rover
)
