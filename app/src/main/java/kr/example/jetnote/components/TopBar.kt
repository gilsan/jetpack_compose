package kr.example.jetnote.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDownCircle
import androidx.compose.material.icons.filled.More
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Person
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
import androidx.navigation.NavController
import kr.example.jetnote.navigation.ScreenNav


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
                        navController.navigate(ScreenNav.ScreenB.name)
                    }) {
                        Text(text="값넘겨주기", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                    }

                    DropdownMenuItem(onClick = {
                        navController.navigate(ScreenNav.ScreenC.name)
                    }) {
                        Text(text="목록", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                    }

                    DropdownMenuItem(onClick = {
                        navController.navigate(ScreenNav.Weather.name)
                    }) {
                        Text(text="날씨", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                    }

                }

                DropdownMenu(expanded = secondShowMenu, onDismissRequest = { secondShowMenu = false }) {
                    DropdownMenuItem(onClick = {
                       navController.navigate(ScreenNav.Movie.name)
                    }) {
                        Text(text="영화", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                    }

                    DropdownMenuItem(onClick = {
                        navController.navigate(ScreenNav.AnimationScreen.name)
                    }) {
                        Text(text="애니메이션", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                    }

                    DropdownMenuItem(onClick = {
                        navController.navigate(ScreenNav.Note2.name)
                    }) {
                        Text(text="기록", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                    }

                    DropdownMenuItem(onClick = {
                        navController.navigate(ScreenNav.Quiz.name)
                    }) {
                        Text(text="퀴즈", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
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
//                      Toast.makeText(context, "메뉴1", Toast.LENGTH_SHORT).show()
                      navController.navigate(ScreenNav.Movie.name)
                  }) {
                      Text(text="영화")
                  }

                  DropdownMenuItem(onClick = {
                      Toast.makeText(context, "메뉴2", Toast.LENGTH_SHORT).show()
                  }) {
                      Text(text="메뉴2")
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

) {
    var showMenu by remember { mutableStateOf(false) }
    var context = LocalContext.current
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
                showMenu = true
            }) {
                Icon(imageVector = Icons.Default.MoreHoriz, contentDescription = "Icon")
            }


            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = {
                    showMenu = false
                }) {

                DropdownMenuItem(onClick = {
                    navController.navigate(ScreenNav.About.name)
                }) {
                    Text(text = "안내")
                }

                DropdownMenuItem(onClick = {
                    navController.navigate(ScreenNav.Favorite.name)
                }) {
                    Text(text = "선호도시")
                }

                DropdownMenuItem(onClick = {
                    navController.navigate(ScreenNav.Setting.name)
                }) {
                    Text(text = "설정")
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