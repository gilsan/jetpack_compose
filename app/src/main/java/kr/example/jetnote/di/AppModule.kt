package kr.example.jetnote.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.example.jetnote.data.NoteDatabase
import kr.example.jetnote.data.NoteDatabaseDao
import kr.example.jetnote.data.weather.WeatherDao
import kr.example.jetnote.data.weather.WeatherDatabase
import kr.example.jetnote.network.QuestionAPI
import kr.example.jetnote.network.ReaderAPI
import kr.example.jetnote.network.WeatherAPI
import kr.example.jetnote.repository.QuestionRepository
import kr.example.jetnote.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNotesDao(noteDatabase: NoteDatabase): NoteDatabaseDao
            = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): NoteDatabase
            = Room.databaseBuilder(
        context,
        NoteDatabase::class.java,
        "notes_db")
        .fallbackToDestructiveMigration()
        .build()


    @Singleton
    @Provides
    fun provideWeatherDao( weatherDatabase: WeatherDatabase): WeatherDao {
        return weatherDatabase.weatherDao()
    }

    @Singleton
    @Provides
    fun provideWeatherAppDatabase(@ApplicationContext context: Context): WeatherDatabase
     = Room.databaseBuilder(
        context,
        WeatherDatabase::class.java,
        "weather_db"
        )
        .fallbackToDestructiveMigration()
        .build()
///////////////////////////////////////////////////////////////////////////////////


    @Singleton
    @Provides
    fun provideQuestionAPI(): QuestionAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(QuestionAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideQuestionRepository(api: QuestionAPI) = QuestionRepository(api)

    @Singleton
    @Provides
    fun provideWeatherAPI(): WeatherAPI {
        return Retrofit.Builder()
                .baseUrl(Constants.WEATHER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(WeatherAPI::class.java)
    }

    //////////// READER   //////////////////

    @Singleton
    @Provides
    fun provideReaderAPI(): ReaderAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.READER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ReaderAPI::class.java)
    }

}