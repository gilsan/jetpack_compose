package kr.example.jetnote.screens.note.data


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kr.example.jetnote.screens.note.model.Memo
import kr.example.jetnote.screens.note.util.DateConverter
import kr.example.jetnote.screens.note.util.UUIDConverter


@Database(entities = [Memo::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class,  UUIDConverter::class)
abstract  class MemoDatabase: RoomDatabase() {
    abstract fun memoDao(): MemoDatabaseDao
}