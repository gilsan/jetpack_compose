package kr.example.jetnote.screens.screenc

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

import kr.example.jetnote.R

val Items = listOf(
    Profile("공리", R.drawable.pineapple),
    Profile("바나나", R.drawable.banana),
    Profile("사과", R.drawable.apple),
    Profile("공리", R.drawable.pineapple),
    Profile("바나나", R.drawable.banana),
    Profile("사과", R.drawable.apple),
    Profile("바나나", R.drawable.banana),
    Profile("파인애플",R.drawable.pineapple),
    Profile("사과", R.drawable.apple),
    Profile("John", R.drawable.john),
    Profile("Andrew", R.drawable.andrew),
    Profile("Elisa", R.drawable.elisa),

    )


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileScreen() {
    var selectedImage by remember { mutableStateOf("")}
    LazyVerticalGrid(cells = GridCells.Adaptive(100.dp) ,
        modifier = Modifier.background(Color(0xFF06292))
    ) {
        Items.forEach { profile ->
            item {
                key(profile.id) {
                    Image(painter = painterResource(id = profile.picture), contentDescription = profile.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(100.dp)
                            .height(100.dp)
                            .background(Color.White)
                            .padding(2.dp)
                            .clickable {
                                selectedImage = profile.id
                            }
                    )


                }
            }
        }
    }
}