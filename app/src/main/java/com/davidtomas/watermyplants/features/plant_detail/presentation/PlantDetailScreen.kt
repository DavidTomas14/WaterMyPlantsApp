package com.davidtomas.watermyplants.features.plant_detail.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.davidtomas.watermyplants.core.util.UiEvent
import com.davidtomas.watermyplants.core_ui.LocalSpacing
import com.davidtomas.watermyplants.features.home.presentation.components.PlantBox
import com.davidtomas.watermyplants.features.plant_detail.presentation.components.DetailSheetComponent
import com.davidtomas.watermyplants.features.plant_detail.presentation.components.FooterButtonComponent
import com.davidtomas.watermyplants.features.plant_detail.presentation.components.HeaderIconsComponent
import com.davidtomas.watermyplants.features.plant_detail.presentation.components.PlantDetailsBanner

@Composable
fun PlantDetailScreen(
    onBackIconClick: () -> Unit,
    onEditIconClick: () -> Unit,
    plantName: String,
    scaffoldState: ScaffoldState,
    viewModel: PlantDetailViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    val state = viewModel.state
    val plants = viewModel.state.plantModels
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
            PlantDetailsBanner()
            DetailSheetComponent(
                modifier = Modifier.weight(1f),
                name = "Plant Name",
                description = "Plant Description"
            )
        }
        HeaderIconsComponent(
            onBackIconClick = onBackIconClick,
            onEditIconClick = onEditIconClick,
            modifier = Modifier.align(Alignment.TopCenter)
        )
        FooterButtonComponent(
            text = "Mark as Watered",
            modifier = Modifier
                .align(Alignment.BottomCenter),
            onClick = {}
        )
    }
}
