package com.davidtomas.watermyplants.features.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidtomas.watermyplants.core.util.UiEvent
import com.davidtomas.watermyplants.features.home.domain.model.PlantModel
import com.davidtomas.watermyplants.features.home.domain.model.PlantStatus
import com.davidtomas.watermyplants.features.home.domain.use_case.CalculateDaysOfWateringPerPlantUseCase
import com.davidtomas.watermyplants.features.home.domain.use_case.DeletePlantUseCase
import com.davidtomas.watermyplants.features.home.domain.use_case.GetPlantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPlantsUseCase: GetPlantsUseCase,
    private val deletePlantUseCase: DeletePlantUseCase,
    private val calculateDaysOfWateringPerPlantUseCase: CalculateDaysOfWateringPerPlantUseCase
) : ViewModel() {
    var state by mutableStateOf(HomeState())
        private set

    private var getPlantsJob: Job? = null

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        viewModelScope.launch {
            refreshPlants()
        }
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnNotificationsClick -> {

            }

            is HomeEvent.OnConfirmDeleteClick -> {
                viewModelScope.launch {
                    state.plantToDelete?.let { deletePlantUseCase.invoke(it) }
                }
            }

            is HomeEvent.OnDeletePlantLongPress -> {
                state = state.copy(
                    plantToDelete = event.plantModel
                )
            }

            is HomeEvent.OnIconClick -> {
                val newPlantList = state.plantModels[state.tabSelected]?.map {
                    if (it.name == event.plantModel.name) {
                        it.copy(
                            //TODO
                            /*needsWater = !it.needsWater*/

                        )
                    } else it
                }
                /* state = state.copy(
                     plantModels = newPlantList
                 )*/
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

    private suspend fun refreshPlants() {
        getPlantsUseCase().collect { plants ->
            val plantsPerStatus = mutableMapOf<PlantStatus, MutableList<PlantModel>>(
                PlantStatus.ForgotToWater to mutableListOf(),
                PlantStatus.Today to mutableListOf(),
                PlantStatus.NextDays to mutableListOf(),
            )
            plants.forEach { plant ->
                calculateDaysOfWateringPerPlantUseCase(plant).forEach { map ->
                    plantsPerStatus[map.key]?.add(map.value)
                }
            }
            state = state.copy(plantModels = plantsPerStatus)
        }
    }
}