package kr.example.jetnote.network

import kr.example.jetnote.model.weathermodel.Weather
import kr.example.jetnote.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherAPI {

    @GET("data/2.5/forecast/daily")
    suspend fun  getWeather(
        @Query("q") query: String,
        @Query("units") units: String = "imperial",
        @Query("appid") appid: String = Constants.API_KEY
    ): Weather
}