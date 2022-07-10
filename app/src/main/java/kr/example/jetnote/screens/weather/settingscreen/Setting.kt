package kr.example.jetnote.screens.weather.settingscreen

import android.provider.Settings
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.example.jetnote.components.TopBar
import kr.example.jetnote.model.weathermodel.TemperatureUnit

@Composable
fun Settings(
    navController: NavController,
    settingViewModel: SettingViewModel = hiltViewModel()

    ) {
    var unitToggleState = remember { mutableStateOf(false)}
    val choiceFromDB = settingViewModel.unitLists.collectAsState().value
    val measurementUnits = listOf<String>("화씨(F)", "섭씨(C)")
    val defaultChoice = if ( choiceFromDB.isNullOrEmpty()) measurementUnits[1] else measurementUnits[0]
    var choiceState = remember { mutableStateOf(defaultChoice) }
    val context= LocalContext.current



    Scaffold(
        topBar = {
            TopBar(title = "설정", icon = Icons.Default.ArrowBack , navController = navController )
        },
    ) {

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            // Text(text="온도표시: $choiceFromDB", fontSize = 20.sp)
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text="온도표시 변경", modifier = Modifier.padding(10.dp))

                IconToggleButton(
                    checked = !unitToggleState.value,
                    onCheckedChange = {
                        unitToggleState.value = !it
                        choiceState.value = if (unitToggleState.value) "화씨(F)" else "섭씨(C)"
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .clip(shape = RectangleShape)
                        .padding(5.dp)
                        .background(color = Color.Magenta.copy(alpha = 0.4f))

                ) {
                    Text(text= if (unitToggleState.value) "화씨(F)" else "섭씨(C)", fontSize = 15.sp, fontWeight = FontWeight.Medium)
                }

                Button(onClick = {
                    settingViewModel.deleteAllUnit()
                    if (unitToggleState.value ) {
                        settingViewModel.insertUnit(TemperatureUnit(unit = "F" ))
                    } else {
                        settingViewModel.insertUnit(TemperatureUnit(unit = "C" ))
                    }
                   Toast.makeText(context, "저장 했습니다.", Toast.LENGTH_SHORT).show()

                }) {
                    Text(text="저장", fontSize = 15.sp, fontWeight = FontWeight.Medium)
                }



            }
        }

    }
}