package com.example.marsroverphotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.data.models.PhotoRoomModel
import com.example.marsroverphotos.home.HomeScreen
import com.example.marsroverphotos.ui.theme.MarsRoverPhotosTheme
import dagger.hilt.android.AndroidEntryPoint

val dataExample = mutableListOf(PhotoRoomModel(
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

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarsRoverPhotosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier,
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}


