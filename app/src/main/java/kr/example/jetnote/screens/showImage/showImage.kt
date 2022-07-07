package kr.example.jetnote.screens.showImage

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kr.example.jetnote.R
import kr.example.jetnote.components.TopBar

@Composable
fun ShowImage(navController: NavController, imageResource: Int, scale: Float, title: String ="") {

    Scaffold(
        topBar = {
            TopBar(title = "이미지보기", icon = Icons.Default.ArrowBack, navController = navController, screen="")
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Card(
                modifier = Modifier.padding(10.dp).fillMaxHeight().fillMaxHeight(),
                elevation = 5.dp
            ) {

                Image(painter = painterResource(id = imageResource),
                    contentDescription = "image",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier.scale(scale)
                )

                Text(title, fontSize = 40.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}