package kr.example.jetnote.screens.home

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kr.example.jetnote.components.HomeTopBar
import kr.example.jetnote.screens.dogprofile.subPages.MusicKnob


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel
    ) {
    Scaffold(
        topBar = {
            HomeTopBar(title = "홈", icon = Icons.Default.Home, navController = navController )
        },
    ) {
        var homeCount by viewModel.homeCount
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()

        ) {
                var field = rememberSaveable {
                    mutableStateOf(0)
                }
//             var fieldValue by remember { mutableStateOf(0) }
//             val countVM: HomeScreenViewModel  = viewModel()
//             val field by countVM.count.observeAsState(0)
             // val fieldValue by countVM.count.observeAsState(0)
            BoxScreen(fieldValue = field.value , navController = navController) {
                    field.value = it
//                fieldValue = it
//                countVM.onCountChange(it)
            }
        }

    }

}

@Composable
fun BoxScreen(
    fieldValue: Int = 0,
    navController: NavController,
    onChange: (Int) -> Unit ={}
) {
    val boxSize = 300.dp

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 2.dp)
                    .size(boxSize)
                    .background(color = Color.Cyan)
                ,
                contentAlignment = Alignment.Center
            ) {
                var childSize = boxSize - 60.dp
                for (i in  0 until  fieldValue ) {
                    Box(
                        modifier = Modifier
                            .size(childSize)
                            .rotate(i * 3f)
                            .background(Color.LightGray)
                            .border(1.dp, Color.White)
                    )
                    childSize -= 20.dp
                }
            }

            OutlinedTextField(
                value = "$fieldValue",
                onValueChange = {
                    Log.d("TAG", "[72] ===> $it ")
                },
                modifier = Modifier.padding(5.dp))

            Row(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButton(onClick = {
                    onChange(fieldValue + 1)
                },
                    modifier = Modifier
                        .padding(2.dp)
                        .border(
                            border = BorderStroke(width = 1.dp, color = Color.Cyan),
                            shape = CircleShape
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Plus" )
                }

                IconButton(onClick = {
                    onChange(if (fieldValue <= 0) 0  else fieldValue - 1)
                },
                    modifier = Modifier
                        .padding(2.dp)
                        .border(
                            border = BorderStroke(width = 1.dp, color = Color.Cyan),
                            shape = CircleShape
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Remove,
                        contentDescription = "Plus" )
                }

            } // End of Row

            MusicKnob( modifier = Modifier.size(150.dp)) {
                onChange((it *100).toInt())

            }

        }

    }
