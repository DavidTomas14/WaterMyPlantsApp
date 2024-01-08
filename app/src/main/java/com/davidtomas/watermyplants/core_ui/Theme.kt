package com.davidtomas.watermyplants.core_ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider


private val DarkColorPalette = darkColors(
    background = neutralus900,
    onBackground = accent600,
    secondary = accent100,
    onSecondary = otherOlive100,
    surface = neutralus0,
    onSurface = neutralus100,
)

private val LightColorPalette = lightColors(
    onPrimary = accent500,
    background = neutralus0,
    onBackground = otherOlive100,
    secondary = accent600,
    surface = neutralus300,
    onSurface = neutralus900
)

/* Other default colors to override
background = Color(0xFFFFFBFE),
surface = Color(0xFFFFFBFE),
onPrimary = Color.White,
onSecondary = Color.White,
onTertiary = Color.White,
onBackground = Color(0xFF1C1B1F),
onSurface = Color(0xFF1C1B1F),
*/

@Composable
fun WaterMyPlantsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    CompositionLocalProvider (LocalSpacing provides Dimensions()) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}