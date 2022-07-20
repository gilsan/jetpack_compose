package kr.example.jetnote.util

import android.icu.text.DateFormat
import android.os.Build
import androidx.annotation.RequiresApi
import com.google.firebase.Timestamp
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter

fun formatDate(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("yyy년 MM월 dd일")

    return format.format(date)

}

fun formatDate2(timestamp: Int): String {
    val sdf = SimpleDateFormat("yyy년 MM월 dd일")
    val date = java.util.Date(timestamp.toLong() * 1000)

    return sdf.format(date)
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



@RequiresApi(Build.VERSION_CODES.N)
fun formatDateFirebase(timestamp: Timestamp): String {
    return DateFormat.getDateInstance().format(timestamp.toDate()).toString().split(",")[0]
}