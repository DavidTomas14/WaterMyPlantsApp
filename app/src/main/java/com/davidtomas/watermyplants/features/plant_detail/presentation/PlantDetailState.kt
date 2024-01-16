package com.davidtomas.watermyplants.features.plant_detail.presentation

import com.davidtomas.watermyplants.features.home.domain.model.PlantModel
import com.davidtomas.watermyplants.features.home.domain.model.PlantStatus

data class PlantDetailState(
    val tabSelected: PlantStatus = PlantStatus.Today,
    val showDialog: Boolean = false,
    val plantModelToDelete: PlantModel? = null,
    val plantModels: List<PlantModel> = listOf(
        PlantModel(
            name = "David",
            description = "Gordo pero fuerte",
            imageUrl = "",
            water = "50ml",
            time = "Mañana",
            wateringDates = listOf()
        ),
        PlantModel(
            name = "Fer",
            description = "Gordo pero fuerte",
            imageUrl = "",
            water = "50ml",
            time = "Mañana",
            wateringDates = listOf()
        ),
        PlantModel(
            name = "Migue",
            description = "Gordo pero fuerte",
            imageUrl = "",
            water = "50ml",
            time = "Mañana",
            wateringDates = listOf()
        )
    )
)