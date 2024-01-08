package com.davidtomas.watermyplants.features.home.presentation

import com.davidtomas.watermyplants.features.home.domain.model.Plant
import com.davidtomas.watermyplants.features.home.domain.model.PlantStatus

sealed class HomeEvent{
    data class OnTabClick(val plantStatus: PlantStatus): HomeEvent()

    object OnNotificationsClick: HomeEvent()
    object OnConfirmDeleteClick: HomeEvent()

    data class OnDeletePlantLongPress(val plant: Plant): HomeEvent()
    data class OnIconClick(val plant: Plant): HomeEvent()

    data class OnPlantClick(val plant: Plant): HomeEvent()
}
