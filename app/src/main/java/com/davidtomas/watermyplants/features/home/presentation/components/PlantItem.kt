package com.davidtomas.watermyplants.features.home.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.davidtomas.watermyplants.R
import com.davidtomas.watermyplants.core_ui.LocalSpacing
import com.davidtomas.watermyplants.features.home.domain.model.Plant

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PlantItem(
    plant: Plant,
    onCardClick: (Plant) -> Unit,
    onCardLongClick: (Plant) -> Unit,
    onIconClick: (Plant) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .wrapContentSize()
            .combinedClickable(
                onClick = { onCardClick(plant) },
                onLongClick = { onCardLongClick(plant) }
            ),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colors.surface
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            ImageSectionWithTags(water = plant.water, date = plant.date)
            ItemFooter(
                name = plant.name,
                description = plant.description,
                needsWater = plant.needsWater,
                onIconClick = {
                    onIconClick(plant)
                }

            )
        }
    }
}

@Composable
fun ImageSectionWithTags(
    water: String,
    date: String,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    Box(modifier = modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.single_plant_placeholder),
            contentDescription = "",
            modifier = Modifier
                .padding(top = spacing.spaceMedium)
                .align(Alignment.Center)
                .scale(0.8f)
        )
        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(spacing.spaceMedium)
        ) {
            InfoTag(tagText = water)
            Spacer(modifier = Modifier.height(spacing.spaceSmall))
            InfoTag(tagText = date)
        }
    }
}

@Composable
fun InfoTag(
    tagText: String
) {
    val spacing = LocalSpacing.current
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .background(MaterialTheme.colors.background.copy(alpha = 0.6f)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(spacing.spaceExtraSmall),
            text = tagText,
        )
    }
}

@Composable
fun ItemFooter(
    name: String,
    description: String,
    needsWater: Boolean,
    onIconClick: () -> Unit
) {
    val spacing = LocalSpacing.current
    Row(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .padding(spacing.spaceMedium),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onPrimary,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(spacing.spaceTiny))
            Text(
                text = description,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(
            modifier = Modifier.weight(0.1f)
        )
        Image(
            painter = if (needsWater) {
                painterResource(id = R.drawable.water_now_icon)
            } else {
                painterResource(id = R.drawable.bordered_check)
            },
            modifier = Modifier
                .clickable {
                    onIconClick()
                },
            contentDescription = "",
        )
    }
}