package com.davidtomas.watermyplants.features.home.domain.model

data class Plant(
    val name: String,
    val description: String,
    val water: String,
    var needsWater: Boolean,
    val time: String,
    val imageUrl: String,
    val plantStatus: PlantStatus
)