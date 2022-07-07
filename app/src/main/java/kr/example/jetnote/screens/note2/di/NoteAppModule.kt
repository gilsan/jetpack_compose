package kr.example.jetnote.screens.note2.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.example.jetnote.screens.note2.data.NoteDatabase
import kr.example.jetnote.screens.note2.data.NoteDatabaseDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NoteAppModule {

    @Singleton
    @Provides
    fun providesNoteDao( noteDatabase: NoteDatabase): NoteDatabaseDao
     = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context): NoteDatabase
     = Room.databaseBuilder(
        context, NoteDatabase::class.java, "notes_db"
        ).fallbackToDestructiveMigration().build()
}