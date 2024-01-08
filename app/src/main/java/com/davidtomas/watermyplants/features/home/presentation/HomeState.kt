package com.davidtomas.watermyplants.features.home.presentation

import com.davidtomas.watermyplants.features.home.domain.model.Plant
import com.davidtomas.watermyplants.features.home.domain.model.PlantStatus

data class HomeState(
    val tabSelected: PlantStatus = PlantStatus.Upcoming,
    val showDialog: Boolean = false,
    val plantToDelete: Plant? = null,
    val plants: List<Plant> = listOf(
        Plant(
            name = "David",
            description = "Gordo pero fuerte",
            imageUrl = "",
            water = "50ml",
            date = "Mañana",
            plantStatus = PlantStatus.Upcoming,
            needsWater = false,
        ),
        Plant(
            name = "Fer",
            description = "Gordo pero fuerte",
            imageUrl = "",
            water = "50ml",
            date = "Mañana",
            plantStatus = PlantStatus.ForgotToWater,
            needsWater = true,
        ),
        Plant(
            name = "Migue",
            description = "Gordo pero fuerte",
            imageUrl = "",
            water = "50ml",
            date = "Mañana",
            plantStatus = PlantStatus.History,
            needsWater = false,
        )
    )
)