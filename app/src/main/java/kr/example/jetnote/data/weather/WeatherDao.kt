package kr.example.jetnote.data.weather

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import kr.example.jetnote.model.weathermodel.Favorite
import kr.example.jetnote.model.weathermodel.TemperatureUnit


@Dao
interface WeatherDao {
    @Query("select * from fav_tbl")
    fun getFavorites(): Flow<List<Favorite>>

    @Query("SELECT * from fav_tbl where city=:city")
    suspend fun getFavById(city: String): Favorite

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: Favorite)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFavorite(favorite: Favorite)

    @Delete
    suspend fun deleteFavorite(favorite: Favorite)


    // Unit
    @Query("SELECT * FROM setting_tbl")
    fun getSettings(): Flow<List<TemperatureUnit>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUnit(unit: TemperatureUnit)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUnit(unit: TemperatureUnit)

    @Delete
    suspend fun deleteUnit(unit: TemperatureUnit)

    @Query("delete from setting_tbl")
    suspend fun  deleteAllUnit()



}