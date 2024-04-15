package com.app.screenpulse.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import com.app.screenpulse.navigation.AppNavigation
import com.app.screenpulse.navigation.Screen

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun ScreenPulseApp(navController: NavHostController, startDestination: String) {
    Box(
        Modifier
            .background(MaterialTheme.colorScheme.surface)
    ) {
        AppNavigation(navController, startDestination)
    }
}