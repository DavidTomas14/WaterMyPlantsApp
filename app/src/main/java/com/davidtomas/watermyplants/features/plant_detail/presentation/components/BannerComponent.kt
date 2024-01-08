package com.davidtomas.watermyplants.features.plant_detail.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.davidtomas.watermyplants.R
import com.davidtomas.watermyplants.core_ui.LocalSpacing

@Composable
fun BannerComponent(
    modifier: Modifier = Modifier,
    url: String? = null
) {
    val spacing = LocalSpacing.current
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        if (url != null) {

        } else {

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(spacing.spaceMedium),
                    painter = painterResource(id = R.drawable.single_plant_placeholder),
                    contentDescription = ""
                )
                InfoInBannerComponent(
                    modifier = Modifier
                        .padding(bottom = spacing.spaceMedium)
                )
            }
        }

    }
}