package com.davidtomas.watermyplants.features.plant_detail.presentation

import com.davidtomas.watermyplants.features.home.domain.model.PlantModel
import com.davidtomas.watermyplants.features.home.domain.model.PlantStatus

sealed class PlantDetailEvent{
    data class OnTabClick(val plantStatus: PlantStatus): PlantDetailEvent()

    object OnNotificationsClick: PlantDetailEvent()
    object OnConfirmDeleteClick: PlantDetailEvent()

    data class OnDeletePlantLongPress(val plantModel: PlantModel): PlantDetailEvent()
    data class OnIconClick(val plantModel: PlantModel): PlantDetailEvent()

    data class OnPlantClick(val plantModel: PlantModel): PlantDetailEvent()
}
