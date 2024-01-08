package com.davidtomas.watermyplants.core_ui

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val default: Dp = 0.dp,
    val spaceTiny: Dp = 4.dp,
    val spaceExtraSmall: Dp = 6.dp,
    val spaceSmall: Dp = 8.dp,
    val spaceMedium: Dp = 16.dp,
    val spaceSemiLarge: Dp = 20.dp,
    val spaceLarge: Dp = 32.dp,
    val spaceExtraLarge: Dp = 64.dp,
)

val LocalSpacing = compositionLocalOf {
    Dimensions()
}
