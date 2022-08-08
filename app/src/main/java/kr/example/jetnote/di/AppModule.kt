package kr.example.jetnote.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.example.jetnote.data.NoteDatabase
import kr.example.jetnote.data.NoteDatabaseDao
import kr.example.jetnote.data.weather.WeatherDao
import kr.example.jetnote.data.weather.WeatherDatabase
import kr.example.jetnote.network.*
import kr.example.jetnote.repository.FirebaseRepository
import kr.example.jetnote.repository.QuestionRepository
import kr.example.jetnote.screens.restfulapi.data.local.BorutoDatabase
import kr.example.jetnote.screens.restfulapi.data.local.HeroDao
import kr.example.jetnote.screens.restfulapi.data.local.HeroRemoteKeysDao
import kr.example.jetnote.screens.restfulapi.utils.BORUTO_DATABASE
import kr.example.jetnote.screens.todo.data.ToDoDao
import kr.example.jetnote.screens.todo.data.ToDoDatabase
import kr.example.jetnote.util.Constants
import kr.example.jetnote.util.Constants.DATABASE_NAME
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

    // Firebase
    @Singleton
    @Provides
    fun provideFirebaseRepository(): FirebaseRepository {
       return FirebaseRepository(queryBook = FirebaseFirestore.getInstance().collection("books"))
    }
/////////////////////////////////////////////////////////
    // News Api
    @Singleton
    @Provides
    fun provideNewsAPI(): NewsAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.NEWS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsAPI::class.java)
    }

 ////////////////////////////////////////////////////////////
  // Unsplash
  @Singleton
  @Provides
  fun provideUnsplashAPI(): UnsplashAPI {
      return Retrofit.Builder()
          .baseUrl(Constants.UNSPLASH_BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build().create(UnsplashAPI::class.java)
  }


//////////////////////////////////////////////////
    /// ToDo Task

    /// ToDo DataBase
    @Singleton
    @Provides
    fun provideToDoDatabase(@ApplicationContext context: Context): ToDoDatabase
     = Room.databaseBuilder(
        context,
        ToDoDatabase::class.java,
        DATABASE_NAME
     ).fallbackToDestructiveMigration().build()

    /// ToDo DAO
    @Singleton
    @Provides
    fun provideToDoDao(toDoDatabase: ToDoDatabase): ToDoDao
     = toDoDatabase.toDoDao()

/////////  Restful API  /////////////
  @Singleton
  @Provides
  fun provideHeroDatabase(@ApplicationContext context: Context): BorutoDatabase
   = Room.databaseBuilder(
    context,
    BorutoDatabase::class.java,
    BORUTO_DATABASE
   ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideHeroDao(borutoDatabase: BorutoDatabase): HeroDao
     = borutoDatabase.heroDao()

    @Singleton
    @Provides
    fun provideHeroRemoteKeyDto(borutoDatabase: BorutoDatabase): HeroRemoteKeysDao
     = borutoDatabase.heroRemoteKeysDao()





}