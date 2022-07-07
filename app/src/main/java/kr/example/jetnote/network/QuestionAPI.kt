package kr.example.jetnote.network

import kr.example.jetnote.model.Question
import retrofit2.http.GET

interface QuestionAPI {

    @GET("world.json")
    suspend fun getAllQuestions(): Question
}