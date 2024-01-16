package com.davidtomas.watermyplants.features.home.presentation

import com.davidtomas.watermyplants.features.home.domain.model.PlantModel
import com.davidtomas.watermyplants.features.home.domain.model.PlantStatus

sealed class HomeEvent{
    data class OnTabClick(val plantStatus: PlantStatus): HomeEvent()

    object OnNotificationsClick: HomeEvent()
    object OnConfirmDeleteClick: HomeEvent()

    data class OnDeletePlantLongPress(val plantModel: PlantModel): HomeEvent()
    data class OnIconClick(val plantModel: PlantModel): HomeEvent()

    data class OnPlantClick(val plantModel: PlantModel): HomeEvent()
}
