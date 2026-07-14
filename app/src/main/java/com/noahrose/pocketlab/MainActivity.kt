package com.noahrose.pocketlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.noahrose.pocketlab.ui.navigation.PocketLabNavigation
import com.noahrose.pocketlab.ui.theme.PocketLabTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PocketLabTheme {
                PocketLabNavigation()
            }
        }
    }
}