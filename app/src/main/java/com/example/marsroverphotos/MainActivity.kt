package com.example.marsroverphotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.domain.models.Photo
import com.example.marsroverphotos.details.DetailScreen
import com.example.marsroverphotos.home.HomeScreen
import com.example.marsroverphotos.ui.theme.MarsRoverPhotosTheme
import dagger.hilt.android.AndroidEntryPoint

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
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController = navController)
        }
        composable(
            route = "${Screen.DetailScreen.route}/{sol}/{imgSrc}/{cameraName}/{roverName}",
            arguments = listOf(
                navArgument("sol"){
                    type = NavType.IntType
                },
                navArgument("imgSrc"){
                    type = NavType.StringType
                },navArgument("cameraName"){
                    type = NavType.StringType
                },navArgument("roverName"){
                    type = NavType.StringType
                }
            )
        ) { entry ->
        DetailScreen(
            Photo(
                0,
                entry.arguments?.getInt("sol", 0) ?: 0,
                entry.arguments?.getString("cameraName","") ?: "" ,
                entry.arguments?.getString("imgSrc","") ?: "" ,
                "" ,
                entry.arguments?.getString("roverName","") ?: "" ,
                )
            )
        }
    }
}