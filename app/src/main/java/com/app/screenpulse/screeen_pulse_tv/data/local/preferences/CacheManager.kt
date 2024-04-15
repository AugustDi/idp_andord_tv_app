package com.app.screenpulse.screeen_pulse_tv.data.local.preferences

import android.content.SharedPreferences

private const val LAST_APP_VISIT = "last_app_visit"
private const val NAME = "name"
private const val LAST_NAME = "last_name"

fun SharedPreferences.saveLastAppVisit(
    date: String
) {
    edit().putString(LAST_APP_VISIT, date).apply()
}

fun SharedPreferences.clearLastAppVisit() {
    edit().putString(LAST_APP_VISIT, null).apply()
}

fun SharedPreferences.getLastAppVisit(): String? {
    return getString(LAST_APP_VISIT, null)
}


fun SharedPreferences.saveName(
    date: String
) {
    edit().putString(NAME, date).apply()
}

fun SharedPreferences.clearName() {
    edit().putString(NAME, null).apply()
}

fun SharedPreferences.getName(): String? {
    return getString(NAME, null)
}

fun SharedPreferences.saveLastName(
    date: String
) {
    edit().putString(LAST_NAME, date).apply()
}

fun SharedPreferences.clearLastName() {
    edit().putString(LAST_NAME, null).apply()
}

fun SharedPreferences.getLastName(): String? {
    return getString(LAST_NAME, null)
}