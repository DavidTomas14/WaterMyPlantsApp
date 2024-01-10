package com.davidtomas.watermyplants.features.add_edit.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.davidtomas.watermyplants.core_ui.LocalSpacing
import com.davidtomas.watermyplants.core_ui.WaterMyPlantsTheme
import java.time.DayOfWeek


@Composable
fun CustomDialog(
    dialogTitle: String,
    onConfirmText: String,
    onCancelText: String,
    onAction: (List<DayOfWeek>) -> Unit,
    modifier: Modifier = Modifier,
    dialogProperties: DialogProperties,
    isVisible: Boolean = false,
    content: @Composable (() -> Unit)? = null
) {
    val spacing = LocalSpacing.current
    var isVisible by remember { mutableStateOf(isVisible) }
    if (isVisible) {
        Dialog(
            onDismissRequest = { isVisible = false },
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
                    if (content != null) {
                        content()
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
                            onClick = { isVisible = false }
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
                            onClick = onAction(date)
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
@Preview
fun CustomDialog() {
    WaterMyPlantsTheme {
        CustomDialog(
            dialogTitle = "Plant Size",
            onConfirmText = "Got it",
            onCancelText = "Cancel",
            dialogProperties = DialogProperties(true, true),
            onAction = {},
            isVisible = true
        ) {

        }
    }
}