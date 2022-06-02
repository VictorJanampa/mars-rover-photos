package com.example.marsroverphotos.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.domain.models.Photo
import com.example.marsroverphotos.ui.theme.RedMars500

@Composable
fun DetailScreen(
    photo: Photo
    ) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .crossfade(true)
                    .data(photo.imgSrc)
                    .build()
            ),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(6.dp)),
            contentScale = ContentScale.Crop
        )
        Box(
            contentAlignment = Alignment.BottomStart,
            modifier = Modifier.fillMaxSize()
        ){
            Column(){
                Text(
                    text = "Sol: ${photo.sol}",
                    style = TextStyle(
                        color = RedMars500,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
                Text(
                    text = "CameraName: ${photo.cameraName}",
                    style = TextStyle(
                    color = RedMars500,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                ),
                    modifier = Modifier.padding(horizontal = 8.dp))
                Text(
                    text = "RoverName: ${photo.roverName}",
                    style = TextStyle(
                    color = RedMars500,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                ),
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
            }
        }

    }
}