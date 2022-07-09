package kr.example.jetnote.screens.weather.aboutscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kr.example.jetnote.R
import kr.example.jetnote.components.TopBar

@Composable
fun About(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(title = "안내", icon = Icons.Default.ArrowBack , navController = navController )
        },
    ) {

        Surface(
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(text= "날씨예보 프로그램 Ver 1.0", fontSize = 25.sp, fontWeight = FontWeight.Medium )
                Text(text= stringResource(id = R.string.about_url), fontSize = 15.sp)
            }
        }

    }
}