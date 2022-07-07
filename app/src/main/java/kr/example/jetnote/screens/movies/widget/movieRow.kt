package kr.example.jetnote.screens.movies.widget

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import kr.example.jetnote.screens.movies.model.Movie

@Composable
fun MovieRow(movie: Movie, onItemClick: (Movie)-> Unit= {}) {

    var expand by  remember { mutableStateOf(false)}

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            // .height(130.dp)
            .clickable {
                onItemClick(movie)
            },
        shape = RoundedCornerShape(corner = CornerSize(12.dp)),
        elevation = 5.dp
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp
            ) {
                Image(painter = rememberAsyncImagePainter(model = movie.images[0]  ),
                    contentDescription = "poster",
                    modifier = Modifier.clip(shape = CircleShape) ,
                    contentScale = ContentScale.Crop)
            }

            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {

                Text(text="영화명: ${movie.title}", fontSize = 15.sp, fontWeight = FontWeight.Normal,
                    overflow = TextOverflow.Ellipsis)
                Text(text="감독: ${movie.director}",  fontSize = 15.sp, fontWeight = FontWeight.Normal)
                Text(text="배우: ${movie.actors}",  fontSize = 15.sp, fontWeight = FontWeight.Normal)
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text="제작년도: ${movie.year}",  fontSize = 15.sp, fontWeight = FontWeight.Normal)
                    Spacer(modifier = Modifier.width(50.dp))
                    Icon(imageVector = if (expand) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown , contentDescription = "icon",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                expand = !expand
                            })
                }

                AnimatedVisibility(visible = expand) {
                    Column() {
                        Text(text="평점: ${movie.rating}",  fontSize = 15.sp, fontWeight = FontWeight.Normal)
                        Text(text="장르: ${movie.genre}",  fontSize = 15.sp, fontWeight = FontWeight.Normal)
                    }

                }


            }


        } // End of Row

    }
}