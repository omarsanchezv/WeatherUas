package com.wizeline.omarsanchez.weatheruas.extentions

import android.text.format.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun String.UTCtoGMT(): String {
    val format = "dd-MM-yyyy"
    var date: String
    val cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
    cal.timeInMillis = this.toLong() * 1000L
    date = DateFormat.format(format, cal.timeInMillis).toString()

    val formatter = SimpleDateFormat(format)
    formatter.timeZone = TimeZone.getTimeZone("UTC")
    val value = formatter.parse(date)

    val dateFormatter = SimpleDateFormat(format)
    dateFormatter.timeZone = Calendar.getInstance().timeZone
    date = dateFormatter.format(value)
    return date
}
//agregar uno mas para concatenar los grados

