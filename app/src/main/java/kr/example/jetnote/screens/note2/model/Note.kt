package kr.example.jetnote.screens.note2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

import java.util.*

@Entity(tableName = "notes_tbl")
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

//    @PrimaryKey(autoGenerate = true)
//    @NonNull
//    @ColumnInfo(name = "productId")
//    var id: Int = 0

    @ColumnInfo(name = "notes_title")
    val title: String,

    @ColumnInfo(name = "notes_description")
    val description: String,

    @ColumnInfo(name = "notes_entry_date")
    val entryDate:  Date = Date(),
)
