package com.app.screenpulse.screeen_pulse_tv.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.screenpulse.screeen_pulse_tv.presentation.splash.state.SplashScreenUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SplashScreenViewModel: ViewModel() {

    private val _uiState = MutableStateFlow<SplashScreenUiState>(SplashScreenUiState.Initial)
    val uiState: StateFlow<SplashScreenUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000)
            _uiState.update { SplashScreenUiState.Success }
        }
    }
}