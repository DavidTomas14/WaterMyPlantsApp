package com.davidtomas.watermyplants.features.add_edit.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import com.davidtomas.watermyplants.core.domain.model.PlantSize
import com.davidtomas.watermyplants.core_ui.WaterMyPlantsTheme

@Composable
fun SizeSelectionDialog(
    sizeSelected: PlantSize,
    onSizeSelected: (PlantSize) -> Unit,
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
    CustomDialog(
        modifier = modifier,
        isVisible = isVisible,
        dialogTitle = dialogTitle,
        onConfirmText = onConfirmText,
        onCancelText = onCancelText,
        onAction = {},
        dialogProperties = dialogProperties
    ) {
        Column {
            PlantSize.values().forEach {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = it == sizeSelected,
                        onClick = {
                            onSizeSelected(it)
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
    }
}

@Composable
@Preview(showBackground = true)
fun SizeSelectionDialogPreview() {
    WaterMyPlantsTheme {
        SizeSelectionDialog(
            dialogTitle = "Plant Size",
            onConfirmText = "Got it",
            onCancelText = "Cancel",
            isVisible = true,
            sizeSelected = PlantSize.XLarge,
            onSizeSelected = {}
        )
    }
}

