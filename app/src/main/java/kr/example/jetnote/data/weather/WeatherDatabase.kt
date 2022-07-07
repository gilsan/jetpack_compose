package kr.example.jetnote.data.weather

import androidx.room.Database
import androidx.room.RoomDatabase
import kr.example.jetnote.model.weathermodel.Favorite
import kr.example.jetnote.model.weathermodel.TemperatureUnit


@Database(entities = [Favorite::class, TemperatureUnit::class], version = 1, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}