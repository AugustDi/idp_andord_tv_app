package com.app.screenpulse.screeen_pulse_tv.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.app.screenpulse.navigation.Screen
import com.app.screenpulse.screeen_pulse_tv.presentation.home.TvHomeScreen
import com.app.screenpulse.screeen_pulse_tv.presentation.screen_pulse.ScreenPulseWebView
import com.app.screenpulse.screeen_pulse_tv.presentation.splash.SplashScreen

const val SCREEN_PULSE_TV_GRAPH_ROUTE_PATTERN = "screen_pulse_tv_graph_route_pattern"

fun NavGraphBuilder.screenPulseTvGraph(
    navController: NavController,
) {
    navigation(
        route = SCREEN_PULSE_TV_GRAPH_ROUTE_PATTERN,
        startDestination = TvScreen.SplashScreen.route
    ) {
        composable(route = TvScreen.SplashScreen.route) {
            SplashScreen { screen ->
                navController.navigate(screen) {
                    popUpTo(navController.graph.id) {
                        inclusive = true
                    }
                }
            }
        }

        composable(route = TvScreen.HomeScreen.route) {
            TvHomeScreen() { route ->
                navController.navigate(route)
            }
        }

        composable(route = TvScreen.ScreenPulseWebView.route) {
            ScreenPulseWebView()
        }
    }
}
