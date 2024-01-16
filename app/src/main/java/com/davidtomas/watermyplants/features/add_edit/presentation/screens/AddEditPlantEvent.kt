package com.davidtomas.watermyplants.features.add_edit.presentation.screens

import com.davidtomas.watermyplants.core.domain.model.PlantSize
import java.time.DayOfWeek

sealed class AddEditPlantEvent{

    object OnFooterButtonClick: AddEditPlantEvent()
    data class OnSelectDateClick(val datesList: List<DayOfWeek>): AddEditPlantEvent()
    data class OnSelectTimeClick(val time: String): AddEditPlantEvent()
    data class OnSelectSize(val size: PlantSize): AddEditPlantEvent()
    data class OnEditPlantNameChanged(val name: String): AddEditPlantEvent()
    data class OnWaterAmountChanged(val amount: String): AddEditPlantEvent()
    data class OnDescriptionChanged(val description: String): AddEditPlantEvent()
}
