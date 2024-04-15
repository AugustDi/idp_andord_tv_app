package com.app.screenpulse.screeen_pulse_tv.presentation.home.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.app.screenpulse.screeen_pulse_tv.navigation.TvScreen

sealed class DrawerScreen(
    val screen: TvScreen,
    val icon: ImageVector,
    val title: String,
) {

    data object UserAccount : DrawerScreen(
        TvScreen.MyAccount,
        Icons.Outlined.AccountCircle,
        "My Account",
    )

    data object HomeScreen : DrawerScreen(
        TvScreen.HomeScreen,
        Icons.Outlined.Home,
        "Home",
    )


    data object ScreenPulseWebViewScreen : DrawerScreen(
        TvScreen.ScreenPulseWebView,
        Icons.Outlined.Warning,
        "Screen Pulse Web"
    )

    data object SettingsScreen : DrawerScreen(
        TvScreen.Settings,
        Icons.Outlined.Settings,
        "Settings",
    )
}

val screenList = listOf(
    DrawerScreen.HomeScreen,
    DrawerScreen.ScreenPulseWebViewScreen
)