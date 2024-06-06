package com.app.screenpulse.screeen_pulse_tv

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.app.screenpulse.navigation.Screen
import com.app.screenpulse.screeen_pulse_tv.data.local.preferences.getLastAppVisit
import com.app.screenpulse.screeen_pulse_tv.data.local.preferences.saveLastAppVisit
import com.app.screenpulse.screeen_pulse_tv.data.parseCalendarDate
import com.app.screenpulse.screeen_pulse_tv.navigation.SCREEN_PULSE_TV_GRAPH_ROUTE_PATTERN
import com.app.screenpulse.ui.ScreenPulseApp
import com.app.screenpulse.ui.theme.AppScreenPulseTheme
import java.time.LocalDate

class TvMainActivity : ComponentActivity() {

    private val sharedPreferences by lazy { initSharedPref() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        IntentFilter(Intent.ACTION_MAIN)
            .apply {
                addCategory(Intent.CATEGORY_HOME)
                addCategory(Intent.CATEGORY_DEFAULT)
            }

        setContent {
            val navController = rememberNavController()

            var showDialogState by remember {
                mutableStateOf(true)
            }


            AppScreenPulseTheme {
                ScreenPulseApp(
                    navController = navController,
                    startDestination = SCREEN_PULSE_TV_GRAPH_ROUTE_PATTERN
                )

//                if (showDialogState) {
//                    AppDialog(text = getLastVisitDate() ?: "something went wrong",
//                        onDismissRequest = {
//                            showDialogState = false
//                        },
//                        onConfirmation = {
//                            showDialogState = false
//
//                        }
//                    )
//                }
            }
        }
    }

    private fun initLastAppVisit() {
        val date = LocalDate.now().parseCalendarDate() ?: return
        sharedPreferences.saveLastAppVisit(date)
    }

    private fun getLastVisitDate() = sharedPreferences.getLastAppVisit()

    private fun initSharedPref() =
        getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    companion object {
        const val SHARED_PREFERENCES_NAME = "screen_pulse_prefs"
    }
}