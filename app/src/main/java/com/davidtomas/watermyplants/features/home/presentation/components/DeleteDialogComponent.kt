package com.davidtomas.watermyplants.features.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.davidtomas.watermyplants.R
import com.davidtomas.watermyplants.core_ui.LocalSpacing


@Composable
fun DeleteDialogComponent(
    modifier: Modifier = Modifier,
    isVisible: Boolean = false,
    dialogProperties: DialogProperties = DialogProperties(),
    onAction: (String) -> Unit,
    onCancel: () -> Unit,
) {
    val spacing = LocalSpacing.current
    if (isVisible) {
        Dialog(
            onDismissRequest = onCancel,
            properties = dialogProperties,
        ) {
            Card(
                modifier = modifier,
            ) {
                Column(
                    modifier = Modifier
                        .padding(spacing.spaceMedium),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start

                    ) {
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(id = R.drawable.delete_icon),
                                contentDescription = stringResource(id = R.string.notifications)
                            )
                        }
                        Text(
                            text = "Are you sure?"
                        )
                    }
                    Text(
                        modifier = Modifier.padding(spacing.spaceMedium),
                        text = "Do you really want to delete the \"Name of plant” This process cannot be undone."
                    )
                    Row {
                        Button(
                            modifier= Modifier.background(Color.White),
                            onClick = { onCancel() }
                        ) {
                            Text(text = "Cancel")
                        }
                        Spacer(modifier = Modifier.width(spacing.spaceMedium))
                        Button(
                            modifier= Modifier.background(MaterialTheme.colors.background),
                            onClick = { onAction("") }
                        ) {
                            Text(text = "Got it")
                        }
                    }
                }
            }
        }
    }
}