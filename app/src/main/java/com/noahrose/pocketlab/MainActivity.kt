package com.noahrose.pocketlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.noahrose.pocketlab.ui.navigation.AtlasNavigation
import com.noahrose.pocketlab.ui.theme.PocketLabTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var darkModeEnabled by remember {
                mutableStateOf(false)
            }

            PocketLabTheme(
                darkTheme = darkModeEnabled,
                dynamicColor = false
            ) {
                AtlasNavigation(
                    darkModeEnabled = darkModeEnabled,
                    onDarkModeChanged = {
                        darkModeEnabled = it
                    }
                )
            }
        }
    }
}