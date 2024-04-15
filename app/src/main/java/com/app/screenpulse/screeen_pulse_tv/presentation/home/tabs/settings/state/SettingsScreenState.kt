package com.app.screenpulse.screeen_pulse_tv.presentation.home.tabs.settings.state

sealed class SettingsScreenState(
    name: String? = null,
    lastName: String? = null
) {
    data object Init: SettingsScreenState()

    data class ShowUserData(
        val userName: String,
        val userLastName: String
    ): SettingsScreenState(name = userName, lastName = userLastName)
}