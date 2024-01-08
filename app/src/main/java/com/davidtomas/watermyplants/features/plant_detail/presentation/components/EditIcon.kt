package com.davidtomas.watermyplants.features.plant_detail.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.davidtomas.watermyplants.R

@Composable
internal fun EditIcon(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .wrapContentSize(),
        color = MaterialTheme.colors.background,
        shape = RoundedCornerShape(40.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.edit2),
            contentDescription = "",
            modifier = Modifier
                .size(35.dp)
                .padding(5.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
        )
    }
}