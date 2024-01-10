package com.davidtomas.watermyplants.features.add_edit.presentation.screens.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.davidtomas.watermyplants.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class AddPlantViewModel @Inject constructor(

) : ViewModel() {
    var state by mutableStateOf(AddPlantState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: AddPlantEvent) {
        when (event) {
            is AddPlantEvent.OnAddPlantClick -> {

            }

            is AddPlantEvent.OnSelectDateClick -> {
               state = state.copy(
                   wateringDates = event.datesList
               )
            }

            is AddPlantEvent.OnSelectSize -> {
                state = state.copy(
                    plantSize = event.size
                )
            }

            is AddPlantEvent.OnSelectTimeClick -> {
                state = state.copy(
                    time = event.time
                )
            }
            is AddPlantEvent.OnWaterAmountChanged -> {
                state = state.copy(
                    water = event.amount
                )
            }

            is AddPlantEvent.OnDescriptionChanged -> {
                state = state.copy(
                    description = event.description
                )
            }

            is AddPlantEvent.OnPlantNameChanged -> {
                state = state.copy(
                    planName = event.name
                )
            }
        }
    }
}