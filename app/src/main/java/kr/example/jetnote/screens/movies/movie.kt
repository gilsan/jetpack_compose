package kr.example.jetnote.screens.movies


import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable

import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import kr.example.jetnote.components.TopBar
import kr.example.jetnote.navigation.ScreenNav
import kr.example.jetnote.screens.movies.model.Movie
import kr.example.jetnote.screens.movies.model.getMovieLists
import kr.example.jetnote.screens.movies.widget.MovieRow


@Composable
fun Movie(navController: NavController) {
    val navControllerBottom = rememberNavController()
    Scaffold(
        topBar = {
            TopBar(title = "영화", icon = Icons.Default.ArrowBack, navController = navController )
        },

        ) {
        val lists: List<Movie> = getMovieLists()

        LazyColumn {
            items(lists) {
                    movie ->
                MovieRow(movie = movie) {
                        movie ->
                    navController.navigate(ScreenNav.MovieDetail.name + "/${movie.id}")

                }
            }

        }
    }
}