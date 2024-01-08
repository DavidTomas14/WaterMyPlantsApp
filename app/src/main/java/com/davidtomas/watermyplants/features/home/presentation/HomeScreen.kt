package com.davidtomas.watermyplants.features.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.davidtomas.watermyplants.R
import com.davidtomas.watermyplants.core.util.UiEvent
import com.davidtomas.watermyplants.core_ui.LocalSpacing
import com.davidtomas.watermyplants.features.home.presentation.components.DeleteDialogComponent
import com.davidtomas.watermyplants.features.home.presentation.components.HeaderComponent
import com.davidtomas.watermyplants.features.home.presentation.components.PlantBox
import com.davidtomas.watermyplants.features.home.presentation.components.PlantItem
import com.davidtomas.watermyplants.features.home.presentation.components.TabsComponent

@Composable
fun HomeScreen(
    scaffoldState: ScaffoldState,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    val state = viewModel.state
    val plants = viewModel.state.plants
    var showDialog by remember { mutableStateOf(false) }


    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                /*is UiEvent.Success -> onNextButtonClick()*/
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
            )
        )
    }
}
