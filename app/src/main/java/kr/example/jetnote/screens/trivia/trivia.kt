package kr.example.jetnote.screens.trivia

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kr.example.jetnote.components.QuestionDisplay
import kr.example.jetnote.components.TopBar
import kr.example.jetnote.model.QuestionItem
import kr.example.jetnote.util.AppColor
import java.lang.Exception


@Composable
fun Trivia(navController: NavController , triviaViewModel: TriviaViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {
            TopBar(title = "퀴즈", icon = Icons.Default.ArrowBack , navController = navController )
        },
    ) {

        TriviaModel( triviaViewModel )

    }

}

@Composable
fun TriviaModel(triviaViewModel: TriviaViewModel ) {
    val questions = triviaViewModel.questionData.value.data?.toMutableList()
    val questionIndex = remember { mutableStateOf(0) }

    if (triviaViewModel.questionData.value.loading == true) {
            androidx.compose.material.Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),

            ) {
                Column(

                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                     CircularProgressIndicator(modifier = Modifier.size(150.dp))
                }
            }
    } else {
         val question = try {
              questions?.get(questionIndex.value)
         } catch(exception: Exception) {
             null
         }
        if (questions != null) {
            QuestionDisplay(
                question = question!!,
                questionIndex = questionIndex,
                viewModel = triviaViewModel,
                ) {
                     questionIndex.value = questionIndex.value + 1
            }
        }

    }
}

