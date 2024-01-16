package com.davidtomas.watermyplants.features.home.domain.model

import java.time.DayOfWeek

data class PlantModel(
    val name: String,
    val description: String,
    val water: String,
    val time: String,
    val wateringDates: List<DayOfWeek>,
    val alreadyWateredDates: List<DayOfWeek>,
    val imageUrl: String,
    val id: Int? = null
)