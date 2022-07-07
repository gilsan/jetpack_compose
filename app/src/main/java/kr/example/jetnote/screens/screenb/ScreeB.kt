package kr.example.jetnote.screens.screenb


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.ImageLoader
import kr.example.jetnote.R
import kr.example.jetnote.components.TopBar
import kr.example.jetnote.navigation.ScreenNav


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ScreenB(navController: NavController) {

    Scaffold(
        topBar = {
            TopBar(title = "값 넘겨주기", icon = Icons.Default.ArrowBack, navController = navController, screen="ScreenB")
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            val boxSize = 350.dp
            var sliderPosition by remember { mutableStateOf(0f)}
            var nameValue by remember { mutableStateOf("")}
            var fruitName by remember { mutableStateOf("")}
            val images = listOf(R.drawable.banana, R.drawable.apple, R.drawable.pineapple)
            var selectedImage by remember { mutableStateOf(0)}
            val keyboardController = LocalSoftwareKeyboardController.current
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(boxSize)
                        .background(Color.LightGray)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth()
                                .padding(top = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            for(i in images.indices) {
                                Image(painter = painterResource(id = images[i]), contentDescription = "null",
                                    modifier = Modifier
                                        .size(width = 100.dp, height = 100.dp)
                                        .selectable(
                                            selected = selectedImage == i, onClick = {
                                                selectedImage = i
                                            }
                                        )
                                        .background(color = if (i == selectedImage) Color.Green else Color.Unspecified),

                                    )
                            }

                        }

                        Slider(
                            value = sliderPosition,
                            onValueChange = {
                                sliderPosition = it
                            },
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .padding(top = 10.dp),
                            valueRange = 0f..2f,
                            colors = SliderDefaults.colors(
                                thumbColor = MaterialTheme.colors.secondary,
                                activeTrackColor = MaterialTheme.colors.secondary
                            )
                        )

                        Row(
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .fillMaxWidth()
                                .padding(start = 20.dp),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(text="크기: ", fontSize = 20.sp )
                            Text(text="$sliderPosition", fontSize = 20.sp )
                        }

                        OutlinedTextField(
                            value = "$fruitName",
                            onValueChange = {
                                fruitName = it
                            },
                            label = {
                                Text(text="이미지명" )
                            },
                            trailingIcon =  {  Icon(imageVector = Icons.Default.Person, contentDescription = "" )  },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Default),
                            keyboardActions = KeyboardActions.Default
                        )


                        Spacer(modifier = Modifier.height(20.dp))
                        Button(onClick = {
                            navController.navigate(ScreenNav.ShowImage.name + "/${images[selectedImage]}/$sliderPosition?name=$fruitName")
                        }) {
                            Text(text = "이미지 보기", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                        }

                    }

                } // End of Box
                Spacer(modifier = Modifier.height(30.dp))
//                Text(text="Text ....")
                OutlinedTextField(
                    value = "$nameValue",
                    onValueChange = {
                        nameValue = it
                    },
                    label = {
                        Text(text="이름" )
                    },
                    trailingIcon =  {  Icon(imageVector = Icons.Default.Person, contentDescription = "" )  },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Default),
                    keyboardActions = KeyboardActions.Default
                )

                Spacer(modifier = Modifier.height(30.dp))

                Button(onClick = {
                    navController.navigate(ScreenNav.Greeting.name +"?name=$nameValue")
                }) {
                    Text(text = "인사하기", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }

            }


        }
    }
}