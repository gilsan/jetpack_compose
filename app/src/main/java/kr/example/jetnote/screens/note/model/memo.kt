package kr.example.jetnote.screens.note.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

import java.util.*

@Entity(tableName = "memo_tbl")
data class Memo(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "memo_title")
    val title: String,

    @ColumnInfo(name = "memo_description")
    val description: String,

    @ColumnInfo(name = "memo_entry_date")
    val entryDate: Date = Date()
)
