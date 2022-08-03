package kr.example.jetnote.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Canvas
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
import kr.example.jetnote.screens.todo.models.Priority
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
                        Text(text="기본 UI", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                   }
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

                    DropdownMenuItem(onClick = {
                        navController.navigate(ScreenNav.SplashScreen.name)
                    }) {
                        Text(text="서고", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
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
                        Text(text="메모", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                    }

                    DropdownMenuItem(onClick = {
                        navController.navigate(ScreenNav.Quiz.name)
                    }) {
                        Text(text="퀴즈", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                    }

                    DropdownMenuItem(onClick = {
                        navController.navigate(ScreenNav.Paging.name)
                    }) {
                        Text(text="페이징", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                    }

                    DropdownMenuItem(onClick = {
                        navController.navigate(ScreenNav.ToDo.name)
                    }) {
                        Text(text="SQLite", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
                    }

                    DropdownMenuItem(onClick = {
                        navController.navigate(ScreenNav.RestfulAPI.name)
                    }) {
                        Text(text="Restful API", fontSize=20.sp, fontWeight = FontWeight.SemiBold)
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
    navController: NavController ,
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
                                .makeText(context, " 도시 추가 했습니다. !!", Toast.LENGTH_SHORT)
                                .show()
                        }
                        .padding(start = 3.dp))
            }

        },
        backgroundColor = Color.Magenta,
        elevation = elevation
    )
}

////  ToDo Task
@Composable
fun DefaultToDoTopBar(
    title: String = "",
    icon: ImageVector ,
    elevation: Dp = 0.dp,
    navController: NavController ,
    screen: String = "",
    onDeleteAll: () -> Unit,
    onSort: (Priority) -> Unit,

) {

    var sortShowMenu by remember { mutableStateOf(false)}
    var deleteShowMenu by remember { mutableStateOf(false)}

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
                      navController.navigate(ScreenNav.ToDoSearch.name)
                  }) {
                      Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = Color.White)
                  }

                IconButton(onClick = {
                    sortShowMenu = true
                }) {
                    Icon(imageVector = Icons.Default.FilterList, contentDescription = null, tint = Color.White)
                }
            
                IconButton(onClick = {deleteShowMenu =true }) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = null, tint = Color.White)
                }

                DropdownMenu(expanded = sortShowMenu, onDismissRequest = { sortShowMenu = false }) {
                    DropdownMenuItem(onClick = {
                        onSort(Priority.LOW)
                        sortShowMenu = false }) {
                        PriorityItem(priority = Priority.LOW)
                    }
                    DropdownMenuItem(onClick = {
                        onSort(Priority.MEDIUM)
                        sortShowMenu= false }) {
                        PriorityItem(priority = Priority.MEDIUM)
                    }
                    DropdownMenuItem(onClick = {
                        onSort(Priority.HIGH)
                        sortShowMenu = false }) {
                        PriorityItem(priority = Priority.HIGH)
                    }
                }

                DropdownMenu(expanded = deleteShowMenu, onDismissRequest = { deleteShowMenu = false }) {
                    DropdownMenuItem(onClick = {
                         onDeleteAll()
                         deleteShowMenu = false
                    }) {
                        Text(text = "전체삭제")
                    }

                }


        },
        navigationIcon = {
            Icon(imageVector = icon, contentDescription = "back icon",
                tint = Color.White, modifier = Modifier.clickable {

                    navController.navigate(ScreenNav.HomeScreen.name) {
                        popUpTo(ScreenNav.HomeScreen.name) { inclusive = true}
                    }

                })
        },
        backgroundColor = Color.Magenta,
        elevation = elevation
    )
}

@Composable
fun PriorityItem(priority: Priority) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(modifier = Modifier.size(16.dp)) {
            drawCircle(color = priority.color)
        }

        Text(text=priority.name, style= MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(start = 10.dp),
            color = MaterialTheme.colors.onSurface)
    }

}



@Composable
fun SearchTopBar(
    title: String = "",
    icon: ImageVector ,
    elevation: Dp = 0.dp,
    navController: NavController ,
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


