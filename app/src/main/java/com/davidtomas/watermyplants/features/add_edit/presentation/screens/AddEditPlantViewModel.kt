package com.davidtomas.watermyplants.features.add_edit.presentation.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidtomas.watermyplants.R
import com.davidtomas.watermyplants.core.util.EMPTY_STRING
import com.davidtomas.watermyplants.core.util.UiEvent
import com.davidtomas.watermyplants.core.util.UiText
import com.davidtomas.watermyplants.core.util.formatToTwoLetterString
import com.davidtomas.watermyplants.features.add_edit.domain.model.AddEditPlantModel
import com.davidtomas.watermyplants.features.add_edit.domain.use_case.AddEditPlantUseCase
import com.davidtomas.watermyplants.features.add_edit.domain.use_case.GetPlantByIdUseCase
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.AddEditPlantEvent.OnDescriptionChanged
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.AddEditPlantEvent.OnEditPlantNameChanged
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.AddEditPlantEvent.OnFooterButtonClick
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.AddEditPlantEvent.OnSelectDateClick
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.AddEditPlantEvent.OnSelectSize
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.AddEditPlantEvent.OnSelectTimeClick
import com.davidtomas.watermyplants.features.add_edit.presentation.screens.AddEditPlantEvent.OnWaterAmountChanged
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AddEditPlantViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val addEditPlantUseCase: AddEditPlantUseCase,
    private val getPlantByIdUseCase: GetPlantByIdUseCase
) : ViewModel() {

    private val idPlant: String? = savedStateHandle["plantId"]
    var state by mutableStateOf(AddEditPlantState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        val isEdit = idPlant != null
        if (isEdit) {
            viewModelScope.launch {
                idPlant?.let {
                    getPlantByIdUseCase.invoke(it.toInt())
                        .collect {
                            state = state.copy(
                                plantName = it.name,
                                wateringDates = it.wateringDates.formatToTwoLetterString(),
                                time = it.time,
                                water = it.water,
                                description = it.description,
                                image = it.imageUrl
                            )
                        }
                }
            }
        }
        state = state.copy(isEdit = isEdit)

    }

    fun onEvent(event: AddEditPlantEvent) {
        when (event) {
            is OnFooterButtonClick -> {
                viewModelScope.launch {
                    addEditPlantUseCase.invoke(
                        AddEditPlantModel(
                            name = state.plantName,
                            description = state.description,
                            water = state.water,
                            time = String.EMPTY_STRING,
                            imageUrl = String.EMPTY_STRING,
                            wateringDates = state.wateringDates,
                            id = if (state.isEdit) idPlant?.toInt() else null
                        )
                    )
                    _uiEvent.send(UiEvent.ShowSnackBar(UiText.StringResource(R.string.plant_succesfully_added)))
                }

            }

            is OnSelectDateClick -> {
                state = state.copy(
                    wateringDates = event.datesList.formatToTwoLetterString()
                )
            }

            is OnSelectSize -> {
                state = state.copy(
                    plantSize = event.size
                )
            }

            is OnSelectTimeClick -> {
                state = state.copy(
                    time = event.time
                )
            }

            is OnWaterAmountChanged -> {
                state = state.copy(
                    water = event.amount
                )
            }

            is OnDescriptionChanged -> {
                state = state.copy(
                    description = event.description
                )
            }

            is OnEditPlantNameChanged -> {
                state = state.copy(
                    plantName = event.name
                )
            }
        }
    }
}