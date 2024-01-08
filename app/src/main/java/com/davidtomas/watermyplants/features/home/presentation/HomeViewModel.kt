package com.davidtomas.watermyplants.features.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidtomas.watermyplants.core.util.UiEvent
import com.davidtomas.watermyplants.core.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {
    var state by mutableStateOf(HomeState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnNotificationsClick -> {

            }

            is HomeEvent.OnConfirmDeleteClick -> {
                viewModelScope.launch {
                    _uiEvent.send(UiEvent.ShowSnackBar(UiText.DynamicString("Lo has borrado crack")))
                }
            }

            is HomeEvent.OnDeletePlantLongPress -> {
                state = state.copy(
                    plantToDelete = event.plant
                )
            }

            is HomeEvent.OnIconClick -> {
                val newPlantList = state.plants.map {
                    if (it.name == event.plant.name)  {
                        it.copy(
                            needsWater = !it.needsWater

                        )
                    } else it
                }
                state = state.copy(
                    plants = newPlantList
                )
            }

            is HomeEvent.OnPlantClick -> {

            }

            is HomeEvent.OnTabClick -> {
                state = state.copy(
                    tabSelected = event.plantStatus
                )
            }
        }
    }
}