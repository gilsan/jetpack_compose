package kr.example.jetnote.screens.note.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.example.jetnote.screens.note.data.MemoDatabase
import kr.example.jetnote.screens.note.data.MemoDatabaseDao

import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NoteAppModule {

    @Singleton
    @Provides
    fun provideNoteDao( noteDatabase: MemoDatabase): MemoDatabaseDao
            = noteDatabase.memoDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): MemoDatabase
            = Room.databaseBuilder(
        context, MemoDatabase::class.java, "memo_db"
    ).fallbackToDestructiveMigration().build()
}

