package com.davidtomas.watermyplants.features.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.davidtomas.watermyplants.R
import com.davidtomas.watermyplants.core_ui.otherOlive500

@Composable
fun PlantBox(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    content: @Composable BoxScope.() -> Unit = {}
) {
    Box(
        contentAlignment = contentAlignment,
        modifier = modifier
            .background(otherOlive500.copy(alpha = 0.5f)) // todo uniform background color for screens, ie MaterialTheme :)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner_plant),
            contentDescription = ""
        )
        content()
    }
}