package com.app.screenpulse.screeen_pulse_tv.navigation

sealed class TvScreen(val route: String) {
    data object SplashScreen : TvScreen("splash_screen")
    data object HomeScreen: TvScreen("tv_home_screen")
    data object WelcomeScreen: TvScreen("welcome_screen")
    data object ScreenPulseWebView: TvScreen("screen_pulse_web_view")
    data object Settings: TvScreen("tv_settings_screen")
    data object MyAccount: TvScreen("tv_my_account")
}