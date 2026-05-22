package br.com.kingscreations.pitstop.features.splash

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertTrue

class SplashScreenTest {

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun splashScreen_deveMostrarLogo_e_navegarAposDelay() = runComposeUiTest {
        // 1. SETUP (Preparação)
        var navegouParaAProximaTela = false

        // Inicia a nossa tela dentro do ambiente de teste
        setContent {
            SplashScreen(onNavigateToNext = {
                navegouParaAProximaTela = true
            })
        }

        // 2. ACT & ASSERT (Ação e Validação Inicial)
        // Verifica se a imagem renderizou buscando pelo contentDescription que definimos
        onNodeWithContentDescription("Logo PitStop").assertExists()

        // Garante que a navegação AINDA NÃO ocorreu, pois o tempo não passou
        assertTrue(!navegouParaAProximaTela, "A navegação não deve ocorrer antes do delay.")

        // 3. AVANÇO NO TEMPO (A Mágica do Relógio Virtual)
        // Avançamos o relógio interno do Compose em 5001 milissegundos
        mainClock.advanceTimeBy(5001L)

        // 4. ASSERT FINAL (Validação)
        // Verifica se o callback foi ativado com sucesso após o tempo esgotar
        assertTrue(navegouParaAProximaTela, "A navegação deveria ter ocorrido após os 5 segundos.")
    }
}