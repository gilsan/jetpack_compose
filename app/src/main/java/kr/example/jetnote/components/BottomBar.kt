package kr.example.jetnote.components
// https://medium.com/@alexruskovski/jetpack-compose-custom-views-c5fe3d6cbb03
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

@Composable
fun  NoteBotttomBar(navController: NavController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val noteScreen = listOf(
        NoteScreen.Home,
        NoteScreen.Profile,
        NoteScreen.Notification
    )

    BottomNavigation {
        noteScreen.forEach {
                screen ->
            BottomNavigationItem(
                selected = currentRoute == screen.route,
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
                })
        }

    }

}

@Composable
fun  AniBottomBar(navController: NavController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val aniScreen = listOf(
        AniScreen.Home,
        AniScreen.Profile,
        AniScreen.Notification
    )

    BottomNavigation {
        aniScreen.forEach {
                screen ->
            BottomNavigationItem(
                selected = currentRoute == screen.route,
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
                })
        }

    }

}

@Composable
fun  FourBottomBar(navController: NavController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val fourScreen = listOf(
        FourScreen.BOM1,
        FourScreen.BOM2,
        FourScreen.BOM3,
        FourScreen.BOM4,
        FourScreen.BOM5
    )

    BottomNavigation {
        fourScreen.forEach {
                screen ->
            BottomNavigationItem(
                selected = currentRoute == screen.route,
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
                })
        }
    }

}

@Composable
fun  RestfulBotttomBar(navController: NavController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val restfulScreen = listOf(
        Restful.HOME,
        Restful.SEARCH,
        Restful.DETAIL

    )

    BottomNavigation {
        restfulScreen.forEach {
                screen ->
            BottomNavigationItem(
                selected = currentRoute == screen.route,
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
                })
        }

    }

}

