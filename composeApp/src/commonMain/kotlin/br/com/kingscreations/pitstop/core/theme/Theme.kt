package br.com.kingscreations.pitstop.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryGreen,
    background = Background01,
    surface = Background02,
    error = ErrorRed,
    onPrimary = White,
    onBackground = White,
    onSurface = LightGray
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryGreen,
    background = White,
    surface = LightGray,
    error = ErrorRed,
    onPrimary = White,
    onBackground = Background01,
    onSurface = DarkGray
)

@Composable
fun PitStopTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}