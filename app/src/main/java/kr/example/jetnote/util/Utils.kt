package kr.example.jetnote.util

import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter

fun formatDate(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("yyy년 MM월 dd일")

    return format.format(date)

}

fun formatWeekday(timestamp: Int): String {
    val sdf = SimpleDateFormat("EEE")
    val date = java.util.Date(timestamp.toLong() * 1000)

    return sdf.format(date)
}

fun formatDateTime(timestamp: Int): String {
    val sdf = SimpleDateFormat("hh:mm:aa")
    val date = java.util.Date(timestamp.toLong() * 1000)

    return sdf.format(date)
}

fun formatDecimals(item: Double): String {
    return " %.0f".format(item)
}