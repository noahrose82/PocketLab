package com.noahrose.pocketlab.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.noahrose.pocketlab.ui.screens.FilesScreen
import com.noahrose.pocketlab.ui.screens.HomeScreen
import com.noahrose.pocketlab.ui.screens.LinuxScreen
import com.noahrose.pocketlab.ui.screens.SettingsScreen
import com.noahrose.pocketlab.ui.screens.TerminalScreen

private data class NavigationItem(
    val route: String,
    val label: String,
    val symbol: String
)

@Composable
fun PocketLabNavigation(
    darkModeEnabled: Boolean,
    onDarkModeChanged: (Boolean) -> Unit
) {
    val navController = rememberNavController()

    val navigationItems = listOf(
        NavigationItem(
            route = "dashboard",
            label = "Dashboard",
            symbol = "⌂"
        ),
        NavigationItem(
            route = "terminal",
            label = "Terminal",
            symbol = ">_"
        ),
        NavigationItem(
            route = "files",
            label = "Files",
            symbol = "▣"
        ),
        NavigationItem(
            route = "linux",
            label = "Linux",
            symbol = "◆"
        ),
        NavigationItem(
            route = "settings",
            label = "Settings",
            symbol = "⚙"
        )
    )

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                navigationItems.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }

                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Text(text = item.symbol)
                        },
                        label = {
                            Text(text = item.label)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "dashboard",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("dashboard") {
                HomeScreen()
            }

            composable("terminal") {
                TerminalScreen()
            }

            composable("files") {
                FilesScreen()
            }

            composable("linux") {
                LinuxScreen()
            }

            composable("settings") {
                SettingsScreen(
                    darkModeEnabled = darkModeEnabled,
                    onDarkModeChanged = onDarkModeChanged
                )
            }
        }
    }
}