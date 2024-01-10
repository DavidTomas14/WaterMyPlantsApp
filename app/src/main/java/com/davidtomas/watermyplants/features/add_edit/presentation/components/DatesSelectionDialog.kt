package com.davidtomas.watermyplants.features.add_edit.presentation.components

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
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
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
fun DatesSelectionDialog(
    dialogTitle: String,
    onConfirmText: String,
    onCancelText: String,
    initialDatesSelected: List<DayOfWeek>,
    onAction: (List<DayOfWeek>) -> Unit,
    modifier: Modifier = Modifier,
    dialogProperties: DialogProperties,
    isVisible: Boolean = false,
) {

    val spacing = LocalSpacing.current
    var isVisible by remember { mutableStateOf(isVisible) }
    var datesSelected by remember { mutableStateOf(initialDatesSelected) }
    var isEveryDaySelected by remember {
        mutableStateOf(
            initialDatesSelected.containsAll(
                listOf(
                    DayOfWeek.MONDAY,
                    DayOfWeek.TUESDAY,
                    DayOfWeek.WEDNESDAY,
                    DayOfWeek.THURSDAY,
                    DayOfWeek.FRIDAY,
                    DayOfWeek.SATURDAY,
                    DayOfWeek.SUNDAY,
                )
            )
        )
    }
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

                    CustomDialog(
                        dialogTitle = dialogTitle,
                        onConfirmText = onConfirmText,
                        onCancelText = onCancelText,
                        onAction = onAction,
                        isVisible = isVisible,
                        dialogProperties = dialogProperties
                    ) {
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = isEveryDaySelected,
                                    onCheckedChange = { isSelected ->
                                        isEveryDaySelected = isSelected
                                        datesSelected = emptyList()
                                    },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = MaterialTheme.colors.onPrimary,
                                        uncheckedColor = Color.Gray
                                    )
                                )
                                Text(
                                    text = "Everyday",
                                    color = if (isEveryDaySelected) Color.Black else Color.Gray,
                                    fontWeight = if (isEveryDaySelected) FontWeight.Bold else FontWeight.Normal
                                )
                            }
                            DayOfWeek.values().forEach { dayOfWeek ->
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    val isDaySelected =
                                        datesSelected.contains(dayOfWeek) && !isEveryDaySelected
                                    Checkbox(
                                        checked = isDaySelected,
                                        onCheckedChange = { isSelected ->
                                            if (isSelected) {
                                                isEveryDaySelected = false
                                                datesSelected = datesSelected.plus(dayOfWeek)
                                            } else
                                                datesSelected = datesSelected.minus(dayOfWeek)
                                        },
                                        colors = CheckboxDefaults.colors(
                                            checkedColor = MaterialTheme.colors.onPrimary,
                                            uncheckedColor = Color.Gray
                                        )
                                    )
                                    Text(
                                        text = dayOfWeek.name.lowercase()
                                            .replaceFirstChar { it.uppercase() },
                                        color = if (isDaySelected) Color.Black else Color.Gray,
                                        fontWeight = if (isDaySelected) FontWeight.Bold else FontWeight.Normal
                                    )
                                }
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
                            onClick = {
                                onAction(datesSelected)
                            }
                        ) {
                            Text(text = onConfirmText)
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun DatesSelectionDialog() {
    WaterMyPlantsTheme {
        DatesSelectionDialog(
            dialogTitle = "Dates",
            datesSelected = listOf(DayOfWeek.MONDAY),
            onConfirmText = "Got it",
            onCancelText = "Cancel",
            onAction = { /*TODO*/ },
            isVisible = true
        )
    }
}