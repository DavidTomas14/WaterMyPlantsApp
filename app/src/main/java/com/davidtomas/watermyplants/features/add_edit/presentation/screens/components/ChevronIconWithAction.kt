package com.davidtomas.watermyplants.features.add_edit.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.davidtomas.watermyplants.R

@Composable
fun ChevronIconWithAction(
    onAction: () -> Unit
) {
    Image(
        modifier = Modifier.clickable { onAction() },
        painter = painterResource(id = R.drawable.chevron_down),
        contentDescription = ""
    )
}