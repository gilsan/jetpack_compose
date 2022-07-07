package kr.example.jetnote.repository

import kotlinx.coroutines.flow.Flow
import kr.example.jetnote.data.weather.WeatherDao
import kr.example.jetnote.model.weathermodel.Favorite
import kr.example.jetnote.model.weathermodel.TemperatureUnit

import javax.inject.Inject

class WeatherRepositoryDao @Inject constructor( private val weatherDao: WeatherDao) {

     fun getFavorite(): Flow<List<Favorite>> {
         return weatherDao.getFavorites()
     }

    suspend fun insertFavorite(favorite: Favorite) {
        return weatherDao.insertFavorite(favorite)
    }

    suspend fun updateFavorite(favorite: Favorite) {
        return weatherDao.updateFavorite(favorite)
    }

    suspend fun deleteFavor(favorite: Favorite) {
        return weatherDao.deleteFavorite(favorite)
    }

    fun getSetting(): Flow<List<TemperatureUnit>> {
        return weatherDao.getSettings()
    }

    suspend fun insertUnit(temperatureUnit: TemperatureUnit) {
        return weatherDao.insertUnit(temperatureUnit)
    }

    suspend fun updateUnit(temperatureUnit: TemperatureUnit) {
        return weatherDao.updateUnit(temperatureUnit)
    }

    suspend fun deleteUnit(temperatureUnit: TemperatureUnit) {
        return weatherDao.deleteUnit(temperatureUnit)
    }
}