package kr.example.jetnote.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*

//import androidx.compose.material.icons.filled.Logout
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kr.example.jetnote.model.weathermodel.Favorite
import kr.example.jetnote.navigation.ScreenNav
import kr.example.jetnote.screens.weather.favoritescreen.FavoriteViewModel



@Composable
fun HomeTopBar(
    title: String = "",
    icon: ImageVector ,
    elevation: Dp = 0.dp,
    navController: NavController,
    screen: String = ""
) {
    var firstShowMenu by remember { mutableStateOf(false)}
    var secondShowMenu by remember { mutableStateOf(false)}

    TopAppBar(
        title= {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text=title, modifier = Modifier.padding(2.dp),
                    color=Color.White,
                    fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        },
        actions = {
                IconButton(onClick = {
                    firstShowMenu  = true
                }) {
                    Icon(imageVector = Icons.Default.ArrowDropDownCircle,
                        contentDescription = "firstIcon",
                        tint= Color.White)
                }

                IconButton(onClick = {
                    secondShowMenu = true
                }) {
                    Icon(imageVector = Icons.Default.Person, contentDescription = "firstIcon", tint=Color.White)
                }


                DropdownMenu(expanded = firstShowMenu, onDismissRequest = { firstShowMenu = false }) {

                    DropdownMenuItem(onClick = {
                        navController.navigate(ScreenNav.FourProfile.name)
                    }) {
                        Text(text="?????? UI", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                   }
                    DropdownMenuItem(onClick = {
                        navController.navigate(ScreenNav.ScreenB.name)
                    }) {
                        Text(text="???????????????", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                    }

                    DropdownMenuItem(onClick = {
                        navController.navigate(ScreenNav.ScreenC.name)
                    }) {
                        Text(text="??????", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                    }

                    DropdownMenuItem(onClick = {
                        navController.navigate(ScreenNav.Weather.name)
                    }) {
                        Text(text="??????", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                    }

                    DropdownMenuItem(onClick = {
                        navController.navigate(ScreenNav.SplashScreen.name)
                    }) {
                        Text(text="??????", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                    }

                }

                DropdownMenu(expanded = secondShowMenu, onDismissRequest = { secondShowMenu = false }) {
                    DropdownMenuItem(onClick = {
                       navController.navigate(ScreenNav.Movie.name)
                    }) {
                        Text(text="??????", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                    }

                    DropdownMenuItem(onClick = {
                        navController.navigate(ScreenNav.AnimationScreen.name)
                    }) {
                        Text(text="???????????????", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                    }

                    DropdownMenuItem(onClick = {
                        navController.navigate(ScreenNav.Note2.name)
                    }) {
                        Text(text="??????", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                    }

                    DropdownMenuItem(onClick = {
                        navController.navigate(ScreenNav.Quiz.name)
                    }) {
                        Text(text="??????", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                    }

                }

        },
        navigationIcon = {
            Icon(imageVector = icon, contentDescription = "icon",
                tint = Color.White )
        },
        backgroundColor = Color.Magenta,
        elevation = elevation
    )
}


@Composable
fun TopBar(
    title: String = "",
    icon: ImageVector ,
    elevation: Dp = 0.dp,
    navController: NavController,
    screen: String = ""
) {


    TopAppBar(
        title= {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text=title, modifier = Modifier.padding(2.dp),
                    color=Color.White,
                    fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        },
        actions = {},
        navigationIcon = {
            Icon(imageVector = icon, contentDescription = "back icon",
                tint = Color.White, modifier = Modifier.clickable {
                    navController.popBackStack()

                })
        },
        backgroundColor = Color.Magenta,
        elevation = elevation
    )
}

@Composable
fun TopBarWithSideBar(
    title: String = "",
    icon: ImageVector ,
    elevation: Dp = 0.dp,
    navController: NavController,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    open: MutableState<Boolean>
    ) {


    TopAppBar(
        title= {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text=title, modifier = Modifier.padding(2.dp),
                    color=Color.White,
                    fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        },
        actions = {

                    IconButton(onClick = {
                       open.value = true
                    }) {
                        Icon(imageVector = Icons.Default.AccountBox, contentDescription = null, tint = Color.White)
                    }

                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu ,
                            contentDescription = null,
                            tint= Color.White
                        )
                    }
        },
        navigationIcon = {
            Icon(imageVector = icon, contentDescription = "back icon",
                tint = Color.White, modifier = Modifier.clickable {
                    navController.popBackStack()

                })
        },
        backgroundColor = Color.Magenta,
        elevation = elevation
    )
}

@Composable
fun TopBarHome(
    title: String = "",
    icon: ImageVector ,
    elevation: Dp = 0.dp,
    navController: NavController,
    screen: String = ""
) {


    TopAppBar(
        title= {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text=title, modifier = Modifier.padding(2.dp),
                    color=Color.White,
                    fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        },
        actions = {},
        navigationIcon = {
            if (screen == "ReaderHome") {
                Icon(imageVector = icon, contentDescription = "back icon",
                    tint = Color.White, modifier = Modifier.clickable {
                        navController.navigate(ScreenNav.ReaderHomeScreen.name)
                    })
            } else {
                Icon(imageVector = icon, contentDescription = "back icon",
                    tint = Color.White, modifier = Modifier.clickable {
                        navController.navigate(ScreenNav.HomeScreen.name)
                    })
            }

        },
        backgroundColor = Color.Magenta,
        elevation = elevation
    )
}


@Composable
fun TopBarReader(
    title: String = "",
    icon: ImageVector ,
    elevation: Dp = 0.dp,
    navController: NavController,

) {

     val auth: FirebaseAuth = FirebaseAuth.getInstance()
    TopAppBar(
        title= {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text=title, modifier = Modifier.padding(2.dp),
                    color=Color.White,
                    fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        },
        actions = {
                  Icon(imageVector = Icons.Default.Logout, contentDescription = "logout", tint = Color.White,
                      modifier = Modifier.clickable {
                          auth.signOut().run {
                              navController.navigate(ScreenNav.LoginScreen.name)
                          }
                      }
                  )
        },
        navigationIcon = {
            Icon(imageVector = icon, contentDescription = "back icon",
                tint = Color.White, modifier = Modifier.clickable {
                    navController.navigate(ScreenNav.HomeScreen.name)

                })
        },
        backgroundColor = Color.Magenta,
        elevation = elevation
    )
}

@Composable
fun PopUpTopBar(
    title: String = "",
    icon: ImageVector ,
    elevation: Dp = 0.dp,
    navController: NavController,
    screen: String = ""
) {


    TopAppBar(
        title= {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text=title, modifier = Modifier.padding(2.dp),
                    color=Color.White,
                    fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        },
        actions = {},
        navigationIcon = {
            Icon(imageVector = icon, contentDescription = "back icon",
                tint = Color.White, modifier = Modifier.clickable {
                    navController.popBackStack()

                })
        },
        backgroundColor = Color.Magenta,
        elevation = elevation
    )
}

@Composable
fun TopBarWithMenu(
    title: String = "",
    icon: ImageVector ,
    elevation: Dp = 0.dp,
    navController: NavController,
    screen: String = ""
) {
    var showMenu by remember { mutableStateOf(false)}
    var context = LocalContext.current
    TopAppBar(
        title= {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text=title, modifier = Modifier.padding(2.dp),
                    color=Color.White,
                    fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        },
        actions = {


              IconButton(onClick = {
                  showMenu = true
              }) {
                  Icon(imageVector = Icons.Default.MoreHoriz, contentDescription = "Icon")
              }


              DropdownMenu(
                  expanded = showMenu ,
                  onDismissRequest = {
                      showMenu = false
                  }) {

                  DropdownMenuItem(onClick = {
//                      Toast.makeText(context, "??????1", Toast.LENGTH_SHORT).show()
                      navController.navigate(ScreenNav.Movie.name)
                  }) {
                      Text(text="??????")
                  }

                  DropdownMenuItem(onClick = {
                      Toast.makeText(context, "??????2", Toast.LENGTH_SHORT).show()
                  }) {
                      Text(text="??????2")
                  }


              }
        },
        navigationIcon = {
            Icon(imageVector = icon, contentDescription = "back icon",
                tint = Color.White, modifier = Modifier.clickable {
                    navController.navigate(ScreenNav.HomeScreen.name)

                })
        },
        backgroundColor = Color.Magenta,
        elevation = elevation
    )
}

@Composable
fun TopBarWeather(
    title: String = "",
    icon: ImageVector ,
    elevation: Dp = 0.dp,
    navController: NavController,
    favoriteViewModel: FavoriteViewModel = hiltViewModel(),
    onAddActionClicked: () -> Unit = {},
    onButtonClicked: ()-> Unit = {}

) {
    var showMenu by remember { mutableStateOf(false) }
    var context = LocalContext.current
    val dataList = title.split(",")
    val isAlreadyDatabase = favoriteViewModel.favLists.collectAsState().value.filter {
        favorite ->
        (favorite.city == dataList[1].trim())
    }
    TopAppBar(
        title = {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title, modifier = Modifier.padding(2.dp),
                    color = Color.White,
                    fontSize = 20.sp, fontWeight = FontWeight.Bold
                )
            }
        },
        actions = {

            IconButton(onClick = {
                onAddActionClicked.invoke()
            }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "search icon")
            }

            IconButton(onClick = {
                showMenu = true
            }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Icon")
            }


            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = {
                    showMenu = false
                }) {

                DropdownMenuItem(onClick = {
                    navController.navigate(ScreenNav.About.name)
                }) {
                    Text(text = "??????")
                }

                DropdownMenuItem(onClick = {
                    navController.navigate(ScreenNav.Favorite.name)
                }) {
                    Text(text = "????????????")
                }

                DropdownMenuItem(onClick = {
                    navController.navigate(ScreenNav.Setting.name)
                }) {
                    Text(text = "??????")
                }



            }
        },
        navigationIcon = {
            Icon(imageVector = icon, contentDescription = "back icon",
                tint = Color.White, modifier = Modifier.clickable {
                    navController.navigate(ScreenNav.HomeScreen.name)

                })

            if (isAlreadyDatabase.isNullOrEmpty()) {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = null, tint = Color.White,
                    modifier = Modifier
                        .clickable {

                            favoriteViewModel.insertFavorite(
                                Favorite(
                                    city = dataList[1].trim(),
                                    country = dataList[0].trim()
                                )
                            )
                            Toast
                                .makeText(context, " ?????? ?????? ????????????. !!", Toast.LENGTH_SHORT)
                                .show()
                        }
                        .padding(start = 3.dp))
            }

        },
        backgroundColor = Color.Magenta,
        elevation = elevation
    )
}
