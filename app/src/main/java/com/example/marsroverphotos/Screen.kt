package com.example.marsroverphotos

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object DetailScreen : Screen("detail_screen")

    fun <T: Any> withArgs(vararg args: T): String{
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}