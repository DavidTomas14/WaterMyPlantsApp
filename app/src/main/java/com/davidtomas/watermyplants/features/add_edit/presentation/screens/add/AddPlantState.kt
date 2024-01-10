package com.davidtomas.watermyplants.features.add_edit.presentation.screens.add

import com.davidtomas.watermyplants.core.domain.model.PlantSize
import com.davidtomas.watermyplants.core.util.EMPTY_STRING
import java.time.DayOfWeek

data class AddPlantState(
    val planName: String = String.EMPTY_STRING,
    val wateringDates: List<DayOfWeek> = emptyList(),
    val time: String = String.EMPTY_STRING,
    val water: String = String.EMPTY_STRING,
    val plantSize: PlantSize = PlantSize.XLarge,
    val description: String = String.EMPTY_STRING,
    val image: String = String.EMPTY_STRING
)