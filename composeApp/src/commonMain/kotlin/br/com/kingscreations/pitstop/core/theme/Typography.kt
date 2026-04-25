package br.com.kingscreations.pitstop.core.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    // 36 - Bold
    displayLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp
    ),
    // 24 - Bold
    headlineLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    // 20 - Bold
    titleLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    // 18 - Bold
    titleMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    // 16 - Regular
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    // 14 - Bold
    labelLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    // 14 - Regular
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    // 12 - Bold
    labelMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),
    // 12 - Regular
    bodySmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)