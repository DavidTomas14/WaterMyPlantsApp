package com.davidtomas.watermyplants.features.add_edit.domain.model

data class AddEditPlantModel(
    val name: String,
    val description: String,
    val water: String,
    val time: String,
    val imageUrl: String,
    val wateringDates: String,
    val id: Int? = null
)
