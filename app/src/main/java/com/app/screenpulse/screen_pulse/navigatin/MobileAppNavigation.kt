package com.app.screenpulse.screen_pulse.navigatin

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.app.screenpulse.screeen_pulse_tv.navigation.TvScreen
import com.app.screenpulse.screeen_pulse_tv.presentation.screen_pulse.ScreenPulseWebView
import com.app.screenpulse.screeen_pulse_tv.presentation.splash.SplashScreen

const val SCREEN_PULSE_MOBILE_GRAPH_ROUTE_PATTERN = "screen_pulse_mobile_graph_route_pattern"

fun NavGraphBuilder.screenPulseMobileGraph(
    navController: NavController,
) {
    navigation(
        route = SCREEN_PULSE_MOBILE_GRAPH_ROUTE_PATTERN,
        startDestination = TvScreen.ScreenPulseWebView.route
    ) {
        composable(route = TvScreen.ScreenPulseWebView.route) {
            ScreenPulseWebView()
        }
    }
}