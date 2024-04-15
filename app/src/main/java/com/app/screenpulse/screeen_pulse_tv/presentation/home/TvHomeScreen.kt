package com.app.screenpulse.screeen_pulse_tv.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.tv.material3.DrawerState
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.NavigationDrawer
import com.app.screenpulse.screeen_pulse_tv.presentation.home.components.AppNavigationDrawer

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun TvHomeScreen(
    navigateTo: (String) -> Unit
) {

    val drawerState = remember { DrawerState() }

    AppNavigationDrawer(
        drawerState = drawerState,
        navigateTo = navigateTo
    )
}
