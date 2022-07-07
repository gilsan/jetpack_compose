package kr.example.jetnote.screens.note.util

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("yyy년 MM월 dd일")

    return format.format(date)

}