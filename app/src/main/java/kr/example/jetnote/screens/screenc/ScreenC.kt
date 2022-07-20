package kr.example.jetnote.screens.screenc

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


import androidx.navigation.compose.rememberNavController
import kr.example.jetnote.components.MyBotttomBar
import kr.example.jetnote.components.Screen
import kr.example.jetnote.components.TopBarWithMenu

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun ScreenC(navController: NavController) {
    val navControllerBottom = rememberNavController()
    Scaffold(
        topBar = {
            TopBarWithMenu(title = "메뉴바", icon = Icons.Default.ArrowBack, navController = navController, screen="ScreenC")
        },
        bottomBar = {
            MyBotttomBar(navController = navControllerBottom)
        }

    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {

            NavHost(navController = navControllerBottom, startDestination = Screen.HomeSub.route, modifier = Modifier.padding(it) ) {
                composable(Screen.HomeSub.route) {
                    HomeScreenSub()
                }

                composable(Screen.Profile.route) {
                    ProfileScreen()
                }

                composable(Screen.Notification.route) {
                    NotificationScreen()
                }

            }
        }
    }
}