package br.com.kingscreations.pitstop.features.splash

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.kingscreations.pitstop.core.theme.Background01
import br.com.kingscreations.pitstop.core.theme.Background02
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import pitstop.composeapp.generated.resources.Res
import pitstop.composeapp.generated.resources.logo_splash

/**
 * Tela Splash Screen do aplicativo PitStop.
 *
 * Responsável por exibir a logo do aplicativo durante um período de tempo
 * Esta tela atua como a primeira impressão do aplicativo, exibindo o logotipo
 * com uma animação de entrada (escala elástica e *fade-in*), seguida por um
 * efeito de pulsação contínua (respiração) na própria logo.
 * * O tempo de retenção desta tela permite pré-carregamentos assíncronos no futuro
 * (ex: validação de token de sessão, carregamento de cache local ou preferências).
 *
 * @param onNavigateToNext Função de callback disparada automaticamente após
 * o tempo de espera (delay) finalizar. Responsável por remover a Splash da pilha
 * de navegação e chamar o próximo fluxo (ex: Onboarding ou Autenticação).
 * * @author Kings Creations
 */
@Composable
fun SplashScreen(onNavigateToNext: () -> Unit) {
    // Controladores da animação de entrada única
    val entranceScale = remember { Animatable(0.6f) }
    val entranceAlpha = remember { Animatable(0f) }

    // Transição infinita para o efeito de "pulsação" direto na logo
    val infiniteTransition = rememberInfiniteTransition()
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.05f, // A logo cresce 5% e volta ao tamanho original
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    LaunchedEffect(key1 = true) {
        // Entrada rápida com efeito elástico
        launch {
            entranceScale.animateTo(
                targetValue = 1.1f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            entranceScale.animateTo(1f, animationSpec = tween(300))
        }
        launch {
            entranceAlpha.animateTo(
                targetValue = 1f,
                animationSpec = tween(1000)
            )
        }

        //  Retenção de 5 segundos
        delay(5000)
        onNavigateToNext()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(Background02, Background01),
                    center = androidx.compose.ui.geometry.Offset.Unspecified,
                    radius = Float.POSITIVE_INFINITY
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.logo_splash),
            contentDescription = "Logo PitStop",
            modifier = Modifier
                .size(260.dp)
                .scale(entranceScale.value * pulseScale)
                .alpha(entranceAlpha.value)
        )
    }
}

/**
 * Preview da SplashScreen para renderização rápida no Android Studio.
 */
@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(onNavigateToNext = {})
}