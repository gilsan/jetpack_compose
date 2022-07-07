package kr.example.jetnote.repository

import kr.example.jetnote.data.DataOrException
import kr.example.jetnote.model.QuestionItem
import kr.example.jetnote.network.QuestionAPI
import javax.inject.Inject

class QuestionRepository @Inject constructor( private  val api: QuestionAPI) {


    private var dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()
    suspend fun  getQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception>   {
        try {
            dataOrException.loading = true
            dataOrException.data =  api.getAllQuestions()
            if (dataOrException.data.toString().isNullOrEmpty()) {

            } else {
                dataOrException.loading = false
            }


        } catch (exception: java.lang.Exception) {
            dataOrException.e = exception
        }
        return dataOrException
    }
}