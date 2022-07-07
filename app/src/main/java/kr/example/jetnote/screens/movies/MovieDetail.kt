package kr.example.jetnote.screens.movies

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import kr.example.jetnote.components.PopUpTopBar
import kr.example.jetnote.screens.movies.model.Movie
import kr.example.jetnote.screens.movies.model.getMovieLists
import kr.example.jetnote.screens.movies.widget.MovieRow

@Composable
fun MovieDetail(navController: NavController, movieID: String?) {

    val movieInfo = getMovieLists().filter {
            item -> item.id == movieID
    }
    Scaffold(
        topBar = {
            PopUpTopBar(title = "상세설명", icon = Icons.Default.ArrowBack, navController = navController )
        }) {

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MovieRow(movie = movieInfo.first()) {

                }
                Spacer(modifier = Modifier.height(30.dp))
                Text(text="영화명: ${movieInfo[0].title}", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(30.dp))
                Divider()
                Text(text="스틸컷", modifier = Modifier.padding(5.dp) , fontSize = 20.sp)
                HorizontalScrollableImageView(newMovieList = movieInfo)
            }
        }
    }

}

@Composable
fun HorizontalScrollableImageView(newMovieList: List<Movie>) {

    LazyRow {
        items(newMovieList[0].images) {
                image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = image),
                    contentDescription = "영화 스틸컷",
                    contentScale = ContentScale.Crop)
            }
        }
    }
}