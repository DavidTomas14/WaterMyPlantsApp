package com.davidtomas.watermyplants.features.add_edit.presentation.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.davidtomas.watermyplants.core.domain.model.PlantSize
import com.davidtomas.watermyplants.core.domain.model.PlantSize.Small
import com.davidtomas.watermyplants.core_ui.LocalSpacing
import com.davidtomas.watermyplants.core_ui.WaterMyPlantsTheme

@Composable
fun SizeSelectionDialog(
    initialSizeSelected: PlantSize,
    onAction: (PlantSize) -> Unit,
    onDismiss: () -> Unit,
    isVisible: Boolean,
    dialogTitle: String,
    onConfirmText: String,
    onCancelText: String,
    dialogProperties: DialogProperties = DialogProperties(
        dismissOnBackPress = true,
        dismissOnClickOutside = true,
    ),
    modifier: Modifier = Modifier,
) {
    val spacing = LocalSpacing.current
    var sizeSelected by remember { mutableStateOf(initialSizeSelected) }
    if (isVisible) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = dialogProperties,
        ) {

            Card(
                backgroundColor = Color.White,
                shape = RoundedCornerShape(10.dp),
                modifier = modifier,
            ) {
                Column(
                    modifier = Modifier
                        .padding(spacing.spaceMedium),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = dialogTitle,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceMedium))
                    Column {
                        PlantSize.values().forEach {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = it == sizeSelected,
                                    onClick = {
                                        sizeSelected = it
                                    },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = MaterialTheme.colors.onPrimary,
                                        unselectedColor = Color.Gray
                                    )
                                )
                                Text(
                                    text = stringResource(id = it.textResId),
                                    color = if (it == sizeSelected) Color.Black else Color.Gray,
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(spacing.spaceTiny))
                    Row {
                        Button(
                            modifier = Modifier
                                .weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.White,
                                contentColor = Color.Black
                            ),
                            onClick = onDismiss
                        ) {
                            Text(text = onCancelText)
                        }
                        Spacer(modifier = Modifier.width(spacing.spaceMedium))
                        Button(
                            modifier = Modifier
                                .weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = MaterialTheme.colors.onPrimary,
                                contentColor = Color.White
                            ),
                            onClick = { onAction(sizeSelected) }
                        ) {
                            Text(text = onConfirmText)
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SizeSelectionDialogPreview() {
    WaterMyPlantsTheme {
        var isVisible by remember {
            mutableStateOf(false)
        }
        SizeSelectionDialog(
            initialSizeSelected = Small,
            onAction = {
                       isVisible = false
            },
            onDismiss = { isVisible = false },
            dialogTitle = "Plant Size",
            onConfirmText = "Got it",
            onCancelText = "Cancel",
            isVisible = isVisible,
        )
    }
}

