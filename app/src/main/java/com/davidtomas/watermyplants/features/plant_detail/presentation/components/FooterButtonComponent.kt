package com.davidtomas.watermyplants.features.plant_detail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.davidtomas.watermyplants.core_ui.LocalSpacing

@Composable
fun FooterButtonComponent(
    text: String,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(spacing.spaceMedium),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.onPrimary,
                contentColor = Color.White
            ),
            onClick = { /*TODO*/ }
        ) {
            Text(text = text)
        }
    }
}