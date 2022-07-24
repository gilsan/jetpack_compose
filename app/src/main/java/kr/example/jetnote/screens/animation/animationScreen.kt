package kr.example.jetnote.screens.animation

import androidx.compose.animation.AnimatedVisibility

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.runtime.Composable

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.example.jetnote.R
import kr.example.jetnote.components.*


@Composable
fun AnimationScreen(navController: NavController) {
    val aniNavController = rememberNavController()
    Scaffold(
        topBar = {
            TopBar(title = "애니메이션", icon = Icons.Default.ArrowBack, navController = navController )
        },
        bottomBar = {
            AniBotttomBar(navController = aniNavController)
        }
    ) {
        androidx.compose.material.Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            NavHost(navController = aniNavController , startDestination = AniScreen.Home.route, modifier = Modifier.padding(it) ) {
                composable(AniScreen.Home.route) {
                    AnimatedVisibilitySample()
                }

                composable(AniScreen.Notification.route) {
                    Animation2()
                }

                composable(AniScreen.Profile.route) {
                    Animation2()
                }

            }

        }
    }
}

@Composable
fun AnimatedVisibilitySample() {

    val (checked, onCheckedChange) = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .shadow(2.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(15.dp)
        ) {
            Checkbox(checked = checked, onCheckedChange = onCheckedChange )
            Text(text = "내용보기" )

            AnimatedVisibility(visible = checked) {
                Box(
                    modifier = Modifier
                        .size(300.dp)
                        .padding(20.dp)
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


@Composable
fun Animation2() {
    var counter = remember {
       mutableStateOf(0)
    }

    val expand = remember { mutableStateOf(false)}


   Surface(
       modifier = Modifier.fillMaxSize()
   ) {

       Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(16.dp)
               .shadow(2.dp)
       ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .padding(15.dp)
            ) {
                IconButton(onClick = {counter.value++}) {
                  Icon(imageVector = Icons.Default.ArrowDownward, contentDescription = null)
                }
                Box(modifier = Modifier.size(150.dp)) {
                    Text("$counter", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }

                IconButton(onClick = {
                    if (counter.value > 0) counter.value--
                }) {
                   Icon(imageVector = Icons.Default.ArrowUpward, contentDescription = null )
                }
            }

           Column(
               modifier = Modifier
                   .fillMaxWidth()
                   .fillMaxHeight(0.5f)
                   .padding(10.dp)
           ) {
               if (expand.value) {
                   Box(modifier = Modifier
                       .wrapContentSize()
                       .background(color = Color.Gray)) {
                       Text(text="문장 대체 \n 문장 대체\n 문장 대체")
                   }
               }
           }
       }

   }
}