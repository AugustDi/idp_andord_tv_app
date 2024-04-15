package com.app.screenpulse.screeen_pulse_tv.presentation.home.tabs.settings.event

import android.content.SharedPreferences

sealed interface SettingsEvent {
    data class NameValueChanged(val name: String): SettingsEvent
    data class LastNameValueChanged(val value: String): SettingsEvent
    data class Save(val sharedPrefs: SharedPreferences): SettingsEvent
}