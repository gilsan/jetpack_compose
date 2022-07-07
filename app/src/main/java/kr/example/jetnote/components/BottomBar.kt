package kr.example.jetnote.components

import android.util.Log
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun MyBotttomBar(navController: NavController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val mainScreen = listOf(
        Screen.HomeSub,
        Screen.Profile,
        Screen.Notification
    )



    BottomNavigation {

        mainScreen.forEach { screen ->
            Log.d("TAG", "[BottomBar][31]==> $screen")

            BottomNavigationItem(
                selected =  currentRoute == screen.route,
                onClick = {
                      navController.navigate(screen.route) {
                          popUpTo(navController.graph.findStartDestination().id) {
                              saveState = true
                          }
                          launchSingleTop = true
                          restoreState = true
                      }
                },
                icon = {
                       Icon(imageVector = screen.icon, contentDescription = screen.title )
                },
                label = {
                    Text(text=screen.title)
                }
            )
        }
    }

}

