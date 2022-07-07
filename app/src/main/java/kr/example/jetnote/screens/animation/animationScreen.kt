package kr.example.jetnote.screens.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kr.example.jetnote.components.TopBar
import kr.example.jetnote.R

@Composable
fun AnimationScreen(navController: NavController) {

    Scaffold(
        topBar = {
            TopBar(title = "애니메이션", icon = Icons.Default.ArrowBack, navController = navController )
        },
    ) {
        AnimatedVisibilitySample()
    }
}

@Composable
fun AnimatedVisibilitySample() {

    val (checked, onCheckedChange) = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .shadow(2.dp).fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(15.dp)
        ) {
            Checkbox(checked = checked, onCheckedChange = onCheckedChange )
            Text(text = "내용보기" )

            AnimatedVisibility(visible = checked) {
                Box(
                    modifier = Modifier.size(300.dp).padding(20.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pineapple),
                        contentDescription = "image" ,
                        modifier = Modifier.clip(shape = RoundedCornerShape(9.dp)),
                        contentScale = ContentScale.Fit)
                }
            }

        }
    }

}