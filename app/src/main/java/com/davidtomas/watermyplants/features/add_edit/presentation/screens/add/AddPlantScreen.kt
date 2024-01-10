package com.davidtomas.watermyplants.features.add_edit.presentation.screens.add

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.davidtomas.watermyplants.R
import com.davidtomas.watermyplants.core.domain.model.PlantSize
import com.davidtomas.watermyplants.core_ui.LocalSpacing
import com.davidtomas.watermyplants.features.add_edit.presentation.components.DatesSelectionDialog
import com.davidtomas.watermyplants.features.add_edit.presentation.components.InputBasic
import com.davidtomas.watermyplants.features.add_edit.presentation.components.SizeSelectionDialog
import java.time.DayOfWeek

@Composable
fun AddScreen(
    scaffoldState: ScaffoldState,
    viewModel: AddPlantViewModel = hiltViewModel()
) {

    val spacing = LocalSpacing.current
    val context = LocalContext.current
    var showSelectSizeDialog by remember { mutableStateOf(false) }
    var showSelectDatesDialog by remember { mutableStateOf(false) }

    val state = viewModel.state

    Column {
        InputBasic(
            labelText = stringResource(id = R.string.plant_name),
            hintText = stringResource(id = R.string.enter_plant_name),
            text = state.planName,
            onTextChanged = { name ->
                viewModel.onEvent(AddPlantEvent.OnPlantNameChanged(name))
            }
        )
    }
        SizeSelectionDialog(
            dialogTitle = "Plant Size",
            onConfirmText = "Got it",
            onCancelText = "Cancel",
            isVisible = showSelectSizeDialog,
            sizeSelected = PlantSize.XLarge,
            onSizeSelected = { size ->
                viewModel.onEvent(AddPlantEvent.OnSelectSize(size))
            }
        )

    DatesSelectionDialog(
        dialogTitle = "Dates",
        datesSelected = listOf(DayOfWeek.MONDAY),
        onConfirmText = "Got it",
        onCancelText = "Cancel",
        onAction = {
                   viewModel.onEvent(AddPlantEvent.OnSelectDateClick())
        },
        isVisible = showSelectDatesDialog
    )

    /* val state = viewModel.state
     val plants = viewModel.state.plants
     var showDialog by remember { mutableStateOf(false) }



     LaunchedEffect(key1 = true) {
         viewModel.uiEvent.collect { event ->
             when (event) {
                 *//*is UiEvent.Success -> onNextButtonClick()*//*
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.asString(context)
                    )
                }

                else -> Unit
            }
        }
    }


    PlantBox {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            HeaderComponent(
                headerText = stringResource(id = R.string.lets_care_my_plants),
                endIcon = Icons.Default.Notifications
            )
            TabsComponent(
                tabSelected = state.tabSelected
            ) { plantStatus ->
                viewModel.onEvent(HomeEvent.OnTabClick(plantStatus))
            }
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(
                    plants.filter { it.plantStatus == viewModel.state.tabSelected },
                    key = { it.name }) { plant ->
                    PlantItem(
                        plant = plant,
                        onCardClick = {
                            onPlantItemClick(it.name)
                        },
                        onCardLongClick = {
                            viewModel.onEvent(HomeEvent.OnDeletePlantLongPress(it))
                            showDialog = true
                        },
                        onIconClick = {
                            viewModel.onEvent(HomeEvent.OnIconClick(it))
                        }
                    )

                }
            }
        }
        DeleteDialogComponent(
            isVisible = showDialog,
            onAction = {
                viewModel.onEvent(HomeEvent.OnConfirmDeleteClick)
                showDialog = false
            },
            onCancel = {
                showDialog = false
            },
            dialogProperties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            ),
            dialogTitle = stringResource(id = R.string.sure_of_delete),
            onCancelText = stringResource(id = R.string.cancel),
            onConfirmText = stringResource(id = R.string.confirm_text)
        )
    }*/
}
