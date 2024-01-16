package com.davidtomas.watermyplants.features.home.presentation

import com.davidtomas.watermyplants.features.home.domain.model.PlantModel
import com.davidtomas.watermyplants.features.home.domain.model.PlantStatus

data class HomeState(
    val tabSelected: PlantStatus = PlantStatus.Today,
    val showDialog: Boolean = false,
    val plantToDelete: PlantModel? = null,
    val plantModels: Map<PlantStatus, List<PlantModel>> = emptyMap()
)