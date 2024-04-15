package com.app.screenpulse.screeen_pulse_tv.presentation.home.tabs.settings

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.app.screenpulse.screeen_pulse_tv.data.local.preferences.getLastName
import com.app.screenpulse.screeen_pulse_tv.data.local.preferences.getName
import com.app.screenpulse.screeen_pulse_tv.data.local.preferences.saveLastAppVisit
import com.app.screenpulse.screeen_pulse_tv.presentation.home.tabs.settings.event.SettingsEvent
import com.app.screenpulse.screeen_pulse_tv.presentation.home.tabs.settings.state.SettingsScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SettingsViewModel: ViewModel() {

    private val _screenSate = MutableStateFlow<SettingsScreenState>(SettingsScreenState.Init)
    val screenSate: StateFlow<SettingsScreenState> = _screenSate.asStateFlow()

    private var prefs: SharedPreferences? = null

    fun onEvent(event: SettingsEvent) {
        when(event) {
            is SettingsEvent.LastNameValueChanged -> TODO()
            is SettingsEvent.NameValueChanged -> TODO()
            is SettingsEvent.Save -> TODO()
        }
    }

    fun setPrefs(sharedPreferences: SharedPreferences) {
        prefs = sharedPreferences
    }

    fun initUserData() {
        _screenSate.update {
            SettingsScreenState.ShowUserData(
                userLastName = prefs?.getLastName() ?: "",
                userName = prefs?.getName() ?: ""
            )
        }
    }
}