package kr.example.jetnote.screens.weather.searchscreen

import android.app.appsearch.AppSearchManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kr.example.jetnote.components.TopBar
import kr.example.jetnote.navigation.ScreenNav

@Composable
fun  Search(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(title = "도시 날씨검색", icon = Icons.Default.ArrowBack , navController = navController )
        },
    ) {

        Surface{
            Column(
               modifier = Modifier.padding(5.dp),
               verticalArrangement = Arrangement.Top,
               horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SearchBar(
                    modifier = Modifier.fillMaxWidth().padding(16.dp).align(Alignment.CenterHorizontally)
                ){
                    navController.navigate(ScreenNav.Weather.name +"/$it")
                }
            }
        }

    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit = {}
) {

    val searchQueryState: MutableState<String> = rememberSaveable {
        mutableStateOf("")
    }
    val keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current
    val valid: Boolean = remember(searchQueryState.value) {
         searchQueryState.value.trim().isNotEmpty()
    }

    Column{
        CommonTextField(
            valueState = searchQueryState,
            labelId = "도시명(영문)",
            onAction = KeyboardActions {
                if (!valid) {
                    return@KeyboardActions
                }
                onSearch(searchQueryState.value.trim())
                searchQueryState.value = ""
                keyboardController?.hide()
            }
            )
    }

}



@Composable
fun CommonTextField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    labelId: String,
    enabled: Boolean = true,
    isSingleLine:Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    OutlinedTextField(value = valueState.value ,
                        onValueChange = {
                                valueState.value = it
                            },
                        modifier = Modifier.fillMaxWidth(),
                        enabled = enabled,
                        textStyle = TextStyle(color=MaterialTheme.colors.onBackground, fontSize = 20.sp),
                        label = { Text(text = labelId)},
                        leadingIcon = { Icon(imageVector = Icons.Rounded.Favorite, contentDescription = null)},
                        singleLine = isSingleLine,
                        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
                        keyboardActions = onAction,
                        shape = RoundedCornerShape(15.dp)
        )


}