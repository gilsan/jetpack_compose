package kr.example.jetnote.screens.note.component

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.sp




@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MemoInputText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {}
) {

    var keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors( backgroundColor = Color.Transparent),
        maxLines =  maxLine,
        label =  { Text(text=label) },
        keyboardOptions = KeyboardOptions.Default.copy(),
        keyboardActions = KeyboardActions(onDone =  {
            onImeAction()
            keyboardController?.hide()
        }) ,
        modifier = modifier,
        textStyle = TextStyle(fontSize = 20.sp)
    )

}

@Composable
fun MemoButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {

    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = CircleShape
    ) {
        Text(text=text)
    }

}