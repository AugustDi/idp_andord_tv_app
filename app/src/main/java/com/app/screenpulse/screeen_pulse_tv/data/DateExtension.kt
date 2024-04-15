package com.app.screenpulse.screeen_pulse_tv.data

import java.time.LocalDate
import java.time.format.DateTimeFormatter

private const val DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
private const val CALENDAR_DATE_PATTERN = "yyyy-MM-dd"

fun LocalDate.parseCalendarDate(): String? {
    val formatter = DateTimeFormatter.ofPattern(CALENDAR_DATE_PATTERN)
    return try {
        format(formatter)
    } catch (e: Exception) {
        null
    }
}