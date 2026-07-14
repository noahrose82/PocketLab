package com.noahrose.pocketlab.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = PocketBlue,
    onPrimary = PocketLightSurface,
    primaryContainer = PocketBlueContainer,
    onPrimaryContainer = PocketLightText,
    background = PocketLightBackground,
    onBackground = PocketLightText,
    surface = PocketLightSurface,
    onSurface = PocketLightText,
    surfaceVariant = PocketBlueContainer,
    onSurfaceVariant = PocketLightText
)

private val MatrixColorScheme = darkColorScheme(
    primary = MatrixGreen,
    onPrimary = MatrixBlack,
    primaryContainer = MatrixGreenDark,
    onPrimaryContainer = MatrixGreenBright,
    secondary = MatrixGreenBright,
    onSecondary = MatrixBlack,
    background = MatrixBlack,
    onBackground = MatrixGreen,
    surface = MatrixSurface,
    onSurface = MatrixGreen,
    surfaceVariant = MatrixSurfaceVariant,
    onSurfaceVariant = MatrixMutedText,
    outline = MatrixBorder,
    error = MatrixGreenBright,
    onError = MatrixBlack
)

@Composable
fun PocketLabTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val view = LocalView.current

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }

        darkTheme -> MatrixColorScheme
        else -> LightColorScheme
    }

    if (!view.isInEditMode) {
        val window = (view.context as Activity).window

        window.statusBarColor = colorScheme.background.toArgb()
        window.navigationBarColor = colorScheme.background.toArgb()

        WindowCompat.getInsetsController(window, view).apply {
            isAppearanceLightStatusBars = !darkTheme
            isAppearanceLightNavigationBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}