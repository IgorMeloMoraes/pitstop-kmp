package br.com.kingscreations.pitstop

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.kingscreations.pitstop.core.theme.PitStopTheme
import br.com.kingscreations.pitstop.features.splash.SplashScreen
import org.jetbrains.compose.resources.painterResource

import pitstop.composeapp.generated.resources.Res
import pitstop.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    PitStopTheme {
        var showSplash by remember { mutableStateOf(true) }

        if (showSplash) {
            SplashScreen(onNavigateToNext = {
                showSplash = false
            })
        } else {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Bem-vindo ao PitStop!", color = Color.White)
            }
        }
    }
}