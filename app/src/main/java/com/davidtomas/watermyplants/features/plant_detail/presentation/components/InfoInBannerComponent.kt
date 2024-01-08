package com.davidtomas.watermyplants.features.plant_detail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.davidtomas.watermyplants.core_ui.LocalSpacing

@Composable
fun InfoInBannerComponent(
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    Row(
        modifier = modifier
            .height(IntrinsicSize.Max)
            .padding(spacing.spaceSmall)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .padding(spacing.spaceSmall),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically

    ) {
        InfoItem(title = "Size", value = "Medium")
        Spacer(
            modifier = Modifier
                .fillMaxHeight(0.6f)
                .width(1.dp)
                .background(MaterialTheme.colors.surface)
        )
        InfoItem(title = "Water", value = "250ml")
        Spacer(
            modifier = Modifier
                .fillMaxHeight(0.6f)
                .width(1.dp)
                .background(MaterialTheme.colors.surface)
        )
        InfoItem(title = "Frequency", value = "2 times/week")
    }
}

@Composable
fun InfoItem(
    title: String,
    value: String
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier.padding(spacing.spaceMedium),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            color = MaterialTheme.colors.surface,
            style = MaterialTheme.typography.caption,
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        Text(
            text = value,
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
    }
}