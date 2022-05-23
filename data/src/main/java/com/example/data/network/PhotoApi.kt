package com.example.data.network

import com.example.data.models.PhotoList
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApiService {
    @GET("rovers/curiosity/photos")
    suspend fun getPhotos(@Query("sol") sol:Int, @Query("api_key") apiKey:String = "DEMO_KEY") : PhotoList
}