package com.app.screenpulse.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.screenpulse.screeen_pulse_tv.navigation.screenPulseTvGraph
import com.app.screenpulse.screeen_pulse_tv.presentation.splash.SplashScreen
import com.app.screenpulse.screen_pulse.navigatin.screenPulseMobileGraph

@Composable
fun AppNavigation(navController: NavHostController, startDestination: String) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        screenPulseTvGraph(navController)

        screenPulseMobileGraph(navController)
    }
}