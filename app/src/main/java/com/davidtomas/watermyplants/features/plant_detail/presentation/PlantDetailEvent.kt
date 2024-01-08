package com.davidtomas.watermyplants.features.plant_detail.presentation

import com.davidtomas.watermyplants.features.home.domain.model.Plant
import com.davidtomas.watermyplants.features.home.domain.model.PlantStatus

sealed class PlantDetailEvent{
    data class OnTabClick(val plantStatus: PlantStatus): PlantDetailEvent()

    object OnNotificationsClick: PlantDetailEvent()
    object OnConfirmDeleteClick: PlantDetailEvent()

    data class OnDeletePlantLongPress(val plant: Plant): PlantDetailEvent()
    data class OnIconClick(val plant: Plant): PlantDetailEvent()

    data class OnPlantClick(val plant: Plant): PlantDetailEvent()
}
