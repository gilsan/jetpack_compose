package kr.example.jetnote.screens.note2.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kr.example.jetnote.screens.note2.model.Note
import kr.example.jetnote.screens.note.util.DateConverter
import kr.example.jetnote.screens.note.util.UUIDConverter


@Database(entities = [Note::class], version = 2, exportSchema = false)
@TypeConverters(DateConverter::class,  UUIDConverter::class)
abstract  class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}