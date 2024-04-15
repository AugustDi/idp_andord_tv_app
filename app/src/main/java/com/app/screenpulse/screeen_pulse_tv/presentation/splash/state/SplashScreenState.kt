package com.app.screenpulse.screeen_pulse_tv.presentation.splash.state

sealed interface SplashScreenUiState {
    data object Initial : SplashScreenUiState
    data class Error(val error: String) : SplashScreenUiState
    data object NoInternetConnection : SplashScreenUiState
    data object Loading : SplashScreenUiState
    data object Success: SplashScreenUiState
}