package com.example.data.network

import com.example.data.models.PhotoList
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApiService {

    @GET("rovers/curiosity/photos")
    suspend fun getPhotos(@Query("sol") sol:Int, @Query("api_key") apiKey:String = "y5SjGAT8KowfOqSgVT1jA7zzj4BTrzYyhVqFH7RJ") : PhotoList

    @GET("rovers/curiosity/photos")
    suspend fun getFilteredPhotos(
        @Query("sol") sol:Int,
        @Query("api_key") apiKey:String = "y5SjGAT8KowfOqSgVT1jA7zzj4BTrzYyhVqFH7RJ",
        @Query("camera") cameraName:String) : PhotoList
}
