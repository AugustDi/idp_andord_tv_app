package com.app.screenpulse.screen_pulse

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.tv.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.ExperimentalTvMaterial3Api
import com.app.screenpulse.screeen_pulse_tv.navigation.SCREEN_PULSE_TV_GRAPH_ROUTE_PATTERN
import com.app.screenpulse.screen_pulse.navigatin.SCREEN_PULSE_MOBILE_GRAPH_ROUTE_PATTERN
import com.app.screenpulse.ui.ScreenPulseApp
import com.app.screenpulse.ui.theme.AppScreenPulseTheme

class MainActivity : ComponentActivity() {

    private val sharedPreferences by lazy { initSharedPref() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            AppScreenPulseTheme {
                ScreenPulseApp(
                    navController = navController,
                    startDestination = SCREEN_PULSE_MOBILE_GRAPH_ROUTE_PATTERN
                )
            }
        }
    }

    private fun initSharedPref() = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    companion object {
        const val SHARED_PREFERENCES_NAME = "screen_pulse_prefs"
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppScreenPulseTheme {
        Greeting("Android")
    }
}