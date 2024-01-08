package com.davidtomas.watermyplants.features.plant_detail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.davidtomas.watermyplants.core_ui.LocalSpacing

@Composable
fun DetailSheetComponent(
    name: String,
    description: String,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(Color.White)
            .padding(spacing.spaceMedium)
            .fillMaxWidth()
    ) {
        Text(
            text = name,
            color = MaterialTheme.colors.surface,
            style = MaterialTheme.typography.h2,
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        Text(
            text = description,
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
    }
}
