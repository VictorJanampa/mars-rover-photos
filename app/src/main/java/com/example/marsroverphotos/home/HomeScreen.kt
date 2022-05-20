package com.example.marsroverphotos.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.data.models.PhotoEntity
import com.example.marsroverphotos.dataExample
import com.example.marsroverphotos.ui.theme.MarsRoverPhotosTheme
import com.example.marsroverphotos.ui.theme.RedMars500

@Composable
fun HomeScreen (viewModel: HomeViewModel = hiltViewModel()){
    HomeScreenContent(state = viewModel.homeState)
}

@Composable
fun HomeScreenContent(state: HomeUiState){
    val photos by state.photosValue.collectAsState()
    PhotosLazyGrid(dataList = photos)
}

@Composable
fun PhotoCard(
    modifier: Modifier,
    imageUrl: String,
    id: Int
){
    Card(
        modifier = modifier
            .clickable { },
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ){
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .crossfade(true)
                        .data(imageUrl)
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
                Text(
                    text = id.toString(),
                    style = TextStyle(
                        color = RedMars500,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }

        }

    }
}

@Composable
fun GridItem(data: PhotoEntity) {
    PhotoCard(
        modifier = Modifier
            .padding(8.dp)
            .aspectRatio(1f)
            .fillMaxWidth(),
        imageUrl = data.img_src,
        id = data.id.toInt(),
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PhotosLazyGrid(dataList: List<PhotoEntity>){
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(4.dp)
    ){
        items(count = dataList.size){ index ->
            GridItem(data = dataList[index])
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PhotoCardPreview() {
    MarsRoverPhotosTheme {
        PhotoCard(
            Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .aspectRatio(1f),
            dataExample[1].img_src,
            dataExample[1].id.toInt(),
        )
    }
}
