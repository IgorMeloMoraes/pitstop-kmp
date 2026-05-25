package br.com.kingscreations.pitstop.features.onboarding.presentation.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.kingscreations.pitstop.core.theme.Background01
import br.com.kingscreations.pitstop.core.theme.PrimaryGreen
import br.com.kingscreations.pitstop.core.theme.White
import br.com.kingscreations.pitstop.core.theme.Gray
import org.jetbrains.compose.resources.painterResource
import pitstop.composeapp.generated.resources.Res
import pitstop.composeapp.generated.resources.welcome_1
import pitstop.composeapp.generated.resources.welcome_2
import pitstop.composeapp.generated.resources.welcome_3


@Composable
fun WelcomeOnboardingScreen(
    onStartClicked: () -> Unit,
    onSkipClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background01)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        // Placeholder da Colagem de Imagens
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp),
            contentAlignment = Alignment.Center
        ) {
            // Imagem Principal
            Image(
                painter = painterResource(Res.drawable.welcome_1),
                contentDescription = null,
                modifier = Modifier
                    .size(240.dp)
                    .clip(CircleShape)
                    .border(2.dp, PrimaryGreen.copy(alpha = 0.5f), CircleShape),
                contentScale = ContentScale.Crop
            )
            // Imagem Secundária 1
            Image(
                painter = painterResource(Res.drawable.welcome_2),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.TopEnd)
                    .offset(x = (-10).dp, y = 20.dp)
                    .clip(CircleShape)
                    .border(1.dp, White.copy(alpha = 0.3f), CircleShape),
                contentScale = ContentScale.Crop
            )
            // Imagem Secundária 2
            Image(
                painter = painterResource(Res.drawable.welcome_3),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.BottomStart)
                    .offset(x = 10.dp, y = (-20).dp)
                    .clip(CircleShape)
                    .border(1.dp, White.copy(alpha = 0.3f), CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Texto com palavra em destaque
        Text(
            text = buildAnnotatedString {
                append("Sua jornada para um ")
                withStyle(style = SpanStyle(color = PrimaryGreen, fontWeight = FontWeight.Bold)) {
                    append("carro impecável")
                }
                append(" começa aqui!")
            },
            style = MaterialTheme.typography.displayLarge.copy(
                fontSize = 32.sp,
                lineHeight = 40.sp,
                textAlign = TextAlign.Center
            ),
            color = White
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Gerencie manutenções, trocas de peças e otimize seus gastos em um só lugar.",
            style = MaterialTheme.typography.bodyLarge,
            color = Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        // Botão Primário (Ir para o carrossel)
        Button(
            onClick = onStartClicked,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text(
                text = "Let's Get Started",
                style = MaterialTheme.typography.titleMedium,
                color = White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão Secundário (Pular)
        TextButton(onClick = onSkipClicked) {
            Text(
                text = "Pular e ir direto",
                color = Gray,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Preview
@Composable
fun WelcomeOnboardingScreenPreview() {
    WelcomeOnboardingScreen(
        onStartClicked = {},
        onSkipClicked = {}
    )
}