package com.davidtomas.watermyplants.features.add_edit.presentation.screens.add

import com.davidtomas.watermyplants.core.domain.model.PlantSize
import java.time.DayOfWeek

sealed class AddPlantEvent{

    object OnAddPlantClick: AddPlantEvent()
    data class OnSelectDateClick(val datesList: List<DayOfWeek>): AddPlantEvent()
    data class OnSelectTimeClick(val time: String): AddPlantEvent()
    data class OnSelectSize(val size: PlantSize): AddPlantEvent()
    data class OnPlantNameChanged(val name: String): AddPlantEvent()
    data class OnWaterAmountChanged(val amount: String): AddPlantEvent()
    data class OnDescriptionChanged(val description: String): AddPlantEvent()
}
