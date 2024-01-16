package com.davidtomas.watermyplants.features.add_edit.presentation.screens

import com.davidtomas.watermyplants.core.domain.model.PlantSize
import com.davidtomas.watermyplants.core.util.EMPTY_STRING

data class AddEditPlantState(
    val plantName: String = String.EMPTY_STRING,
    val wateringDates: String = String.EMPTY_STRING,
    val time: String = String.EMPTY_STRING,
    val water: String = String.EMPTY_STRING,
    val plantSize: PlantSize = PlantSize.Medium,
    val description: String = String.EMPTY_STRING,
    val image: String = String.EMPTY_STRING,
    val isEdit: Boolean = false
)