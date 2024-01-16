package com.davidtomas.watermyplants.features.add_edit.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davidtomas.watermyplants.R
import com.davidtomas.watermyplants.core_ui.LocalSpacing
import com.davidtomas.watermyplants.core_ui.WaterMyPlantsTheme

@Composable
fun AddPlantBanner(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    url: String? = null
) {
    val spacing = LocalSpacing.current
    Box(
        modifier = modifier
    ) {
        if (url != null) {

        } else {

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(spacing.spaceMedium),
                    painter = painterResource(id = R.drawable.single_plant_placeholder),
                    contentDescription = ""
                )
                Button(
                    modifier = Modifier
                        .padding(spacing.spaceSmall),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.onPrimary,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(15.dp),
                    onClick = onClick,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.upload_icon),
                            contentDescription = ""
                        )
                        Spacer(modifier = Modifier.width(spacing.spaceMedium))
                        Text(text = stringResource(id = R.string.button_change_image))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun BannerComponentPreview() {
    WaterMyPlantsTheme {
        AddPlantBanner(
            onClick = {}
        )
    }
}