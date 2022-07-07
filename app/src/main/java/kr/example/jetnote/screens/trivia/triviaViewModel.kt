package kr.example.jetnote.screens.trivia

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.example.jetnote.data.DataOrException
import kr.example.jetnote.model.QuestionItem
import kr.example.jetnote.repository.QuestionRepository
import java.lang.Exception

import javax.inject.Inject


@HiltViewModel
class TriviaViewModel @Inject constructor( private val repository: QuestionRepository): ViewModel() {

    val questionData: MutableState<DataOrException<ArrayList<QuestionItem>, Boolean, Exception>> =(
            mutableStateOf( DataOrException(null, true, Exception("")))
    )

    init {
        getAllQuestions()
    }


    private fun getAllQuestions() {
        viewModelScope.launch  {
            questionData.value.loading = true
            questionData.value = repository.getQuestions()
            if (questionData.value.data.toString().isNullOrBlank()) {

            } else {
                questionData.value.loading = false
            }
        }
    }

    fun getQuestionsCount(): Int {
        return questionData.value.data?.toMutableList()?.size!!
    }
}