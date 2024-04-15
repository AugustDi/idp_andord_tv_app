package com.app.screenpulse.screeen_pulse_tv.presentation.home.tabs.settings

import android.content.Context
import android.os.FileUtils.ProgressListener
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.tv.material3.Button
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.ProvideTextStyle
import androidx.tv.material3.Text
import com.app.screenpulse.screeen_pulse_tv.TvMainActivity
import com.app.screenpulse.screeen_pulse_tv.presentation.home.tabs.settings.event.SettingsEvent
import com.app.screenpulse.screeen_pulse_tv.presentation.home.tabs.settings.state.SettingsScreenState
import com.app.screenpulse.ui.components.AnimatedCircularProgressIndicator
import com.app.screenpulse.ui.components.InputTextField

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = viewModel(),
) {
    val screenState by viewModel.screenSate.collectAsState()
    val context = LocalContext.current
    val prefs = remember {
       context.getSharedPreferences(TvMainActivity.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }
    LaunchedEffect(Unit) {
        viewModel.apply {
            setPrefs(prefs)
            initUserData()
        }
    }

    Log.e("TEST", "HERE")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        when(val state = screenState) {
            SettingsScreenState.Init -> {
                AnimatedCircularProgressIndicator()
            }
            is SettingsScreenState.ShowUserData -> {
                Column(modifier = Modifier
                    .weight(1f)
                ) {
                    InputTextField(
                        modifier = Modifier.background(Color.Blue)
                            .fillMaxWidth().padding(vertical = 20.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        onValueChange = {
                            viewModel.onEvent(SettingsEvent.NameValueChanged(it))
                        },
                        value = state.userName
                    )

                    InputTextField(
                        modifier = Modifier.background(Color.White)
                            .fillMaxWidth().padding(top = 40.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        onValueChange = {
                            viewModel.onEvent(SettingsEvent.LastNameValueChanged(it))
                        },
                        value = state.userLastName,
                    )
                }

                Button(onClick = {
                    viewModel.onEvent(SettingsEvent.Save(prefs))
                }) {
                    Text(text = "Save")
                }
            }
        }

    }
}