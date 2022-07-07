package kr.example.jetnote.screens.note.util

import androidx.room.TypeConverter
import java.util.*

class DateConverter {
    @TypeConverter
    fun timeStampFromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun dateFromTimestamp(timestamp: Long): Date? {
        return Date(timestamp)
    }
}