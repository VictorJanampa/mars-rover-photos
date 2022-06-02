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
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.data.models.CameraType
import com.example.domain.models.Photo
import com.example.marsroverphotos.Screen
import com.example.marsroverphotos.ui.theme.MarsRoverPhotosTheme
import com.example.marsroverphotos.ui.theme.RedMars500
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun HomeScreen (
    viewModel: HomeViewModel = hiltViewModel(),
                navController: NavHostController
){
    HomeScreenContent(state = viewModel.homeState, navController = navController)
}

@Composable
fun HomeScreenContent(state: HomeUiState, navController: NavHostController){
    val photos by state.photosValue.collectAsState()
    val selectedChip by state.selectedChip.collectAsState()
    Column(Modifier) {
        FilterChipRow(
            items = CameraType.values(),
            modifier = Modifier.padding(8.dp),
            chipModifier = Modifier.padding(end = 8.dp),
            onClickChip = state.onSelectedChip,
            selectedChip = selectedChip
        )
        PhotosLazyGrid(dataList = photos, navController = navController)
    }

}

@Composable
fun PhotoCard(
    photo: Photo,
    modifier: Modifier,
    navController: NavHostController
){
    Card(
        modifier = modifier
            .clickable {
                val encodedUrl = URLEncoder.encode(photo.imgSrc, StandardCharsets.UTF_8.toString())
                navController.navigate(
                    Screen.DetailScreen.withArgs(photo.sol,encodedUrl,photo.cameraName, photo.roverName)
               )
            },
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
                Text(
                    text = photo.id.toString(),
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
fun GridItem(photo: Photo, navController: NavHostController) {
    PhotoCard(
        modifier = Modifier
            .padding(8.dp)
            .aspectRatio(1f)
            .fillMaxWidth(),
        photo = photo,
        navController = navController
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PhotosLazyGrid(dataList: List<Photo>, navController: NavHostController){
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(4.dp)
    ){
        items(count = dataList.size){ index ->
            GridItem(photo = dataList[index], navController = navController)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PhotoCardPreview() {
    MarsRoverPhotosTheme {

    }
}
