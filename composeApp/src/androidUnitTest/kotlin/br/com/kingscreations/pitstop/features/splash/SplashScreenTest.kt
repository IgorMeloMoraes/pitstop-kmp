package br.com.kingscreations.pitstop.features.splash

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.runComposeUiTest
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import kotlin.test.Test
import kotlin.test.assertTrue

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE, sdk = [34])
class SplashScreenTest {

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun splashScreen_deveMostrarLogo_e_navegarAposDelay() = runComposeUiTest {
        var navegouParaAProximaTela = false

        setContent {
            SplashScreen(onNavigateToNext = {
                navegouParaAProximaTela = true
            })
        }

        onNodeWithContentDescription("Logo PitStop").assertExists()
        assertTrue(!navegouParaAProximaTela, "A navegação não deve ocorrer antes do delay.")
        mainClock.advanceTimeBy(5001L)
        assertTrue(navegouParaAProximaTela, "A navegação deveria ter ocorrido após os 5 segundos.")
    }
}