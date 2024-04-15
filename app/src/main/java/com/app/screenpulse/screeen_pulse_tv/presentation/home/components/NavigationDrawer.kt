package com.app.screenpulse.screeen_pulse_tv.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.items
import androidx.tv.material3.DrawerState
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Icon
import androidx.tv.material3.NavigationDrawer
import androidx.tv.material3.NavigationDrawerItem
import androidx.tv.material3.Text
import com.app.screenpulse.screeen_pulse_tv.navigation.TvScreen
import com.app.screenpulse.screeen_pulse_tv.presentation.home.tabs.account.AccountScreen
import com.app.screenpulse.screeen_pulse_tv.presentation.home.tabs.settings.SettingsScreen
import com.app.screenpulse.screeen_pulse_tv.presentation.home.tabs.welcome.WelcomeScreen

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun AppNavigationDrawer(
    drawerState: DrawerState,
    navigateTo: (String) -> Unit
) {
    val defaultSelection: DrawerScreen = DrawerScreen.HomeScreen

    var currentScreen by remember { mutableStateOf(defaultSelection) }
    val collapsedDrawerItemWidth = 56.dp
    val paddingValue = 12.dp

    NavigationDrawer(
        modifier = Modifier,
        drawerState = drawerState,
        drawerContent = {
            Column(
                Modifier
                    .fillMaxHeight()
                    .padding(12.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                NavigationDrawerItem(
                    selected = currentScreen == DrawerScreen.UserAccount,
                    onClick = {
                        currentScreen = DrawerScreen.UserAccount
                    },
                    leadingContent = {
                        Icon(
                            imageVector = DrawerScreen.UserAccount.icon,
                            contentDescription = null,
                        )
                    }
                ) {
                    Text(DrawerScreen.UserAccount.title)
                }

                TvLazyColumn(
                    Modifier.selectableGroup(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
                ) {

                    items(screenList, key = { it.screen.route }) { screen ->
                        NavigationDrawerItem(
                            selected = currentScreen == screen,
                            onClick = {
                                currentScreen = screen
                            },
                            leadingContent = {
                                Icon(
                                    imageVector = screen.icon,
                                    contentDescription = null,
                                )
                            }
                        ) {
                            Text(screen.title)
                        }
                    }
                }

                NavigationDrawerItem(
                    selected = currentScreen == DrawerScreen.SettingsScreen,
                    onClick = {
                        currentScreen = DrawerScreen.SettingsScreen
                    },
                    leadingContent = {
                        Icon(
                            imageVector = DrawerScreen.SettingsScreen.icon,
                            contentDescription = null,
                        )
                    }
                ) {
                    Text(DrawerScreen.SettingsScreen.title)
                }
            }
        }
    ) {
        val navController = rememberNavController()

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            NavHost(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = collapsedDrawerItemWidth + (paddingValue * 2)),
                navController = navController,
                startDestination = TvScreen.WelcomeScreen.route,
            ) {
                composable(route = TvScreen.WelcomeScreen.route) {
                    WelcomeScreen()
                }
                composable(route = TvScreen.Settings.route) {
                    SettingsScreen()
                }
                composable(route = TvScreen.MyAccount.route) {
                    AccountScreen()
                }
            }
        }
        when (currentScreen) {
            DrawerScreen.HomeScreen -> {
                navigate(TvScreen.WelcomeScreen.route, navController)
            }

            DrawerScreen.SettingsScreen -> {
                navigate(TvScreen.Settings.route, navController)
            }

            DrawerScreen.UserAccount -> {
                navigate(TvScreen.MyAccount.route, navController)
            }

            DrawerScreen.ScreenPulseWebViewScreen -> {
                navigateTo(TvScreen.ScreenPulseWebView.route)
                currentScreen = DrawerScreen.HomeScreen
            }
        }

    }
}

private fun navigate(route: String, navController: NavController) {
    val navOptions: NavOptions = navOptions {
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
    navController.navigate(route, navOptions)
}
