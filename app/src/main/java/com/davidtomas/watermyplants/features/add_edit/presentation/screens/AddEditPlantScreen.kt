package com.davidtomas.watermyplants.features.add_edit.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.davidtomas.watermyplants.R
import com.davidtomas.watermyplants.R.string
import com.davidtomas.watermyplants.core.domain.model.PlantSize.XLarge
import com.davidtomas.watermyplants.core.util.UiEvent
import com.davidtomas.watermyplants.core_ui.LocalSpacing
import com.davidtomas.watermyplants.core_ui.WaterMyPlantsTheme
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.AddEditPlantEvent.OnDescriptionChanged
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.AddEditPlantEvent.OnEditPlantNameChanged
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.AddEditPlantEvent.OnFooterButtonClick
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.AddEditPlantEvent.OnSelectDateClick
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.AddEditPlantEvent.OnSelectSize
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.AddEditPlantEvent.OnWaterAmountChanged
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.components.AddPlantBanner
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.components.ChevronIconWithAction
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.components.DatesSelectionDialog
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.components.InputBasic
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.components.SizeSelectionDialog
import com.davidtomas.watermyplants.features.home.presentation.components.PlantBox
import com.davidtomas.watermyplants.features.plant_detail.presentation.components.FooterButtonComponent
import java.time.DayOfWeek.MONDAY

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AddEditPlantScreen(
    plantId: String?,
    scaffoldState: ScaffoldState,
    navigateHome: () -> Unit,
    viewModel: AddEditPlantViewModel = hiltViewModel()
) {

    val spacing = LocalSpacing.current
    val context = LocalContext.current
    var showSelectSizeDialog by remember { mutableStateOf(false) }
    var showSelectDatesDialog by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    val state = viewModel.state

    LaunchedEffect(key1 = keyboardController) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.asString(context)
                    )
                    keyboardController?.hide()
                }

                else -> Unit
            }
        }
    }

    PlantBox {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            AddPlantBanner(
                onClick = {}
            )
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                    .background(Color.White)
                    .padding(spacing.spaceMedium)
            ) {
                InputBasic(
                    modifier = Modifier.fillMaxWidth(),
                    labelText = stringResource(id = string.label_plant_name),
                    hintText = stringResource(id = string.hint_enter_plant_name),
                    text = state.plantName,
                    onTextChanged = { name ->
                        viewModel.onEvent(OnEditPlantNameChanged(name))
                    }
                )
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                Row {
                    InputBasic(
                        modifier = Modifier.weight(1f),
                        labelText = stringResource(id = string.label_plant_dates),
                        hintText = stringResource(id = string.hint_select_dates),
                        text = state.wateringDates,
                        onTextChanged = { name ->
                            viewModel.onEvent(OnEditPlantNameChanged(name))
                        },
                        enableInput = false,
                        trailingIcon = {
                            ChevronIconWithAction {
                                showSelectDatesDialog = true
                            }
                        }
                    )
                    Spacer(modifier = Modifier.width(spacing.spaceMedium))
                    InputBasic(
                        modifier = Modifier.weight(1f),
                        labelText = stringResource(id = string.label_plant_time),
                        hintText = stringResource(id = string.hint_select_time),
                        text = state.time,
                        enableInput = false,
                        onTextChanged = { name ->
                            viewModel.onEvent(OnEditPlantNameChanged(name))
                        },
                        trailingIcon = {
                            ChevronIconWithAction {

                            }
                        }
                    )
                }
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                Row {
                    InputBasic(
                        modifier = Modifier.weight(1f),
                        labelText = stringResource(id = string.label_plant_water),
                        hintText = stringResource(id = string.hint_enter_plant_water),
                        text = state.water,
                        onTextChanged = { water ->
                            viewModel.onEvent(OnWaterAmountChanged(water))
                        }
                    )
                    Spacer(modifier = Modifier.width(spacing.spaceMedium))
                    InputBasic(
                        modifier = Modifier.weight(1f),
                        labelText = stringResource(id = string.label_plant_size),
                        hintText = stringResource(id = string.hint_select_size),
                        text = stringResource(id = state.plantSize.textResId),
                        onTextChanged = { name ->
                            viewModel.onEvent(OnEditPlantNameChanged(name))
                        },
                        maxLength = 100,
                        enableInput = false,
                        trailingIcon = {
                            ChevronIconWithAction {
                                showSelectSizeDialog = true
                            }
                        }
                    )
                }
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                InputBasic(
                    labelText = stringResource(id = string.label_plant_description),
                    hintText = stringResource(id = string.hint_enter_plant_description),
                    text = state.description,
                    onTextChanged = { description ->
                        viewModel.onEvent(OnDescriptionChanged(description))
                    }
                )

            }
            FooterButtonComponent(
                modifier = Modifier,
                text = stringResource(id = if (state.isEdit) R.string.save_changes else R.string.button_create_plant),
                onClick = {
                    viewModel.onEvent(OnFooterButtonClick)
                    navigateHome()
                }
            )
        }
        SizeSelectionDialog(
            dialogTitle = stringResource(id = string.label_plant_size),
            onConfirmText = stringResource(id = string.button_confirm),
            onCancelText = stringResource(id = string.button_cancel),
            isVisible = showSelectSizeDialog,
            initialSizeSelected = XLarge,
            onAction = { size ->
                viewModel.onEvent(OnSelectSize(size))
                showSelectSizeDialog = false
            },
            onDismiss = {
                showSelectSizeDialog = false
            }
        )

        DatesSelectionDialog(
            dialogTitle = stringResource(id = string.label_plant_dates),
            onConfirmText = stringResource(id = string.button_confirm),
            onCancelText = stringResource(id = string.button_cancel),
            initialDatesSelected = listOf(MONDAY),
            onAction = { datesSelected ->
                viewModel.onEvent(OnSelectDateClick(datesSelected.sortedBy { it.value }))
                showSelectDatesDialog = false

            },
            onDismiss = {
                showSelectDatesDialog = false
            },
            isVisible = showSelectDatesDialog
        )
    }
}

