package com.davidtomas.watermyplants.features.home.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.davidtomas.watermyplants.features.home.domain.model.PlantStatus

@Composable
fun TabsComponent(
    tabSelected: PlantStatus,
    modifier: Modifier = Modifier,
    textSize: TextStyle = MaterialTheme.typography.h5,
    textColor: Color = MaterialTheme.colors.onPrimary,
    disabledTextColor: Color = MaterialTheme.colors.surface,
    barColor: Color = MaterialTheme.colors.onPrimary,
    onTabClick: (PlantStatus) -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        val plantsStatusOrder = listOf(
            PlantStatus.Today,
            PlantStatus.ForgotToWater,
            PlantStatus.NextDays
        )
        plantsStatusOrder.forEach { plantStatus ->
            TabItem(
                tabText = plantStatus.name,
                isSelected = plantStatus == tabSelected,
                textSize = textSize,
                textColor = textColor,
                disabledTextColor = disabledTextColor,
                barColor = barColor,
                onTabClick = { onTabClick(plantStatus) }
            )
        }
    }
}


@Composable
fun TabItem(
    tabText: String,
    isSelected: Boolean,
    textSize: TextStyle,
    textColor: Color,
    disabledTextColor: Color,
    barColor: Color,
    onTabClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(IntrinsicSize.Max)
            .clickable { onTabClick() }
    ) {
        Text(
            text = tabText,
            style = textSize,
            color = if (isSelected) textColor else disabledTextColor,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
        )
        if (isSelected) {
            Canvas(
                modifier = Modifier
                    .height(2.dp)
                    .fillMaxWidth(0.4f)
            ) {
                drawRoundRect(
                    color = barColor,
                    size = size,
                    cornerRadius = CornerRadius(100f)
                )
            }
        }
    }
}