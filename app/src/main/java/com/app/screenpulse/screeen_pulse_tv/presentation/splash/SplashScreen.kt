package com.app.screenpulse.screeen_pulse_tv.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.screenpulse.R
import com.app.screenpulse.navigation.Screen
import com.app.screenpulse.screeen_pulse_tv.navigation.TvScreen
import com.app.screenpulse.screeen_pulse_tv.presentation.home.TvHomeScreen
import com.app.screenpulse.ui.extensions.gradientBackground
import com.app.screenpulse.screeen_pulse_tv.presentation.splash.state.SplashScreenUiState
import com.app.screenpulse.ui.theme.Pink80
import com.app.screenpulse.ui.theme.Purple80

@Composable
fun SplashScreen(
    viewModel: SplashScreenViewModel = viewModel(),
    onNavigate: (String) -> Unit,
) {
    val splashScreenState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .gradientBackground(getGradientColors(), 0f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.ic_splash_tv),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }

    LaunchedEffect(splashScreenState) {
        when (splashScreenState) {
            SplashScreenUiState.Initial -> {}
            SplashScreenUiState.Loading -> {}
            is SplashScreenUiState.Success -> onNavigate(TvScreen.HomeScreen.route)
            SplashScreenUiState.NoInternetConnection -> {}
            is SplashScreenUiState.Error -> {}
        }
    }
}

@Composable
fun getGradientColors() = listOf(
    Purple80,
    Pink80
)