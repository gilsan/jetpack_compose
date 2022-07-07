package kr.example.jetnote.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.example.jetnote.model.QuestionItem
import kr.example.jetnote.screens.trivia.TriviaViewModel
import kr.example.jetnote.util.AppColor


@Composable
fun QuestionDisplay(
    question: QuestionItem,
    questionIndex: MutableState<Int>,
    viewModel: TriviaViewModel,
    onNextClicked: (Int) -> Unit = {}
) {

    val answerState = remember(question) { mutableStateOf<Int?>(null) }
    val choicesState = remember(question) {  question.choices.toMutableList() }
    val correctAnswerState = remember(question) { mutableStateOf<Boolean?>(null)}
    val updateAnswer: (Int)-> Unit = remember(question) {
        {
            answerState.value = it
            correctAnswerState.value = choicesState[it] == question.answer
        }
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),

        color=AppColor.mDarkPurple
    ) {

        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            if (questionIndex.value >= 2) {
                ShowProgress(score = questionIndex.value)
            }
            QuestionTracker(counter = questionIndex.value + 1, outof = viewModel.getQuestionsCount())
            val pathEffect = PathEffect.dashPathEffect(intervals = floatArrayOf(10f, 10f), phase=0f)
            DrawDottedLine(pathEffect = pathEffect)

            Column(

            ) {
                Text(text=question.question,
                    modifier= Modifier
                        .padding(6.dp)
                        .align(Alignment.Start)
                        .fillMaxHeight(0.3f),
                    fontSize = 17.sp,
                    color=AppColor.mOffWhite,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 22.sp
                )
                // choide
                choicesState.forEachIndexed { index, answerText ->
                    Row(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                            .height(55.dp)
                            .border(
                                width = 4.dp,
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        AppColor.mOffDarkPurple,
                                        AppColor.mOffDarkPurple
                                    )
                                ),
                                shape = RoundedCornerShape(15.dp)
                            )
                            .clip(
                                shape = RoundedCornerShape(
                                    topStartPercent = 50,
                                    topEndPercent = 50,
                                    bottomEndPercent = 50,
                                    bottomStartPercent = 50
                                )
                            )
                            .background(color = Color.Transparent),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        RadioButton(selected = answerState.value == index, onClick = {
                                    updateAnswer(index)
                        },
                                modifier = Modifier.padding(start=16.dp),
                                colors = RadioButtonDefaults.colors(
                                            selectedColor = if (correctAnswerState.value == true && index == answerState.value) {
                                                Color.Green.copy(alpha = 0.4f)
                                            } else {
                                                Color.Red.copy(alpha = 0.4f)
                                            }
                                )
                            ) // End of RadioButton

                        val annotationString = buildAnnotatedString {
                            withStyle( style = SpanStyle(
                                color =  if (correctAnswerState.value == true && index == answerState.value) {
                                                Color.Green
                                            } else {
                                                Color.Red
                                            }
                            )
                            ) {
                                append(answerText)
                            }
                        }

                        Text(text=annotationString, modifier = Modifier.padding(10.dp))
                    } //

                } // End of Choices

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            onNextClicked(questionIndex.value)
                                  },
                        modifier = Modifier
                            .padding(3.dp)
                            .align(alignment = Alignment.CenterVertically),
                        shape = RoundedCornerShape(34.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = AppColor.mLightBlue
                        )
                    ) {

                        Text(text="다 음", color=Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    }
                }

            }

        }
    }
}

@Composable
fun QuestionTracker(counter: Int = 10, outof: Int =20) {
    Text(text= buildAnnotatedString {
        withStyle( style= ParagraphStyle(textIndent = TextIndent.None)) {
            withStyle(style = SpanStyle(color=AppColor.mLightGray, fontSize = 27.sp, fontWeight = FontWeight.Bold)) {
                append("질문수: $counter /")
            }
            withStyle(style = SpanStyle(color=AppColor.mLightGray, fontSize = 14.sp, fontWeight = FontWeight.Normal)) {
                append("$outof")
            }
        }
    })
}

@Composable
fun DrawDottedLine(pathEffect: PathEffect) {
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)
        .padding(top = 3.dp, bottom = 3.dp)) {
        drawLine(color=AppColor.mLightGray, start= Offset(0f, 0f), end = Offset(size.width, 0f), pathEffect = pathEffect)
    }
}

@Composable
fun ShowProgress(score: Int = 12) {

    val brush = Brush.linearGradient(colors = listOf(Color(0xFFF95075), Color(0xFFBE6BE5)))
    val progressFactor = remember { mutableStateOf(score * 0.005f)  }
    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(55.dp)
            .border(
                width = 4.dp,
                brush = Brush.linearGradient(
                    colors = listOf(
                        AppColor.mOffDarkPurple,
                        AppColor.mOffDarkPurple
                    )
                ),
                shape = RoundedCornerShape(15.dp)
            )
            .clip(
                shape = RoundedCornerShape(
                    topStartPercent = 50,
                    topEndPercent = 50,
                    bottomEndPercent = 50,
                    bottomStartPercent = 50
                )
            )
            .background(color = Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Button(onClick = { /*TODO*/ },
                contentPadding = PaddingValues(1.dp),
                modifier = Modifier
                    .fillMaxWidth(progressFactor.value)
                    .background(brush = brush),
                enabled = false,
                elevation = null,
                colors =  ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent, disabledBackgroundColor = Color.Transparent
                )
            ) {
            Text(text="${score.toString()}",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.37f)
                    .padding(3.dp),
                color=AppColor.mOffWhite,
                textAlign = TextAlign.Center
                )
        }
    }

}