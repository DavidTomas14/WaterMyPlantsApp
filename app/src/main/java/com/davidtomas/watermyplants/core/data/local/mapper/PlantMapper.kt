package com.davidtomas.watermyplants.core.data.local.mapper

import com.davidtomas.watermyplants.core.data.local.entity.PlantEntity
import com.davidtomas.watermyplants.core.util.EMPTY_STRING
import com.davidtomas.watermyplants.core.util.formatToListOfDayWeek
import com.davidtomas.watermyplants.core.util.formatToTwoLetterString
import com.davidtomas.watermyplants.features.add_edit.domain.model.AddEditPlantModel
import com.davidtomas.watermyplants.features.home.domain.model.PlantModel

fun PlantEntity.toPlant(): PlantModel {
    return PlantModel(
        name = name,
        description = description,
        water = water,
        time = time,
        imageUrl = imageUrl,
        wateringDates = wateringDates.formatToListOfDayWeek(),
        alreadyWateredDates = wateringDates.formatToListOfDayWeek(),
        id = id
    )
}

fun AddEditPlantModel.toPlantEntity(): PlantEntity {
    return PlantEntity(
        name = name,
        description = description,
        water = water,
        time = time,
        wateringDates = wateringDates,
        alreadyWateredDated = String.EMPTY_STRING,
        imageUrl = imageUrl,
        id = id
    )
}
fun PlantModel.toPlantEntity(): PlantEntity {
    return PlantEntity(
        name = name,
        description = description,
        water = water,
        time = time,
        wateringDates = wateringDates.formatToTwoLetterString(),
        alreadyWateredDated = alreadyWateredDates.formatToTwoLetterString(),
        imageUrl = imageUrl,
        id = id
    )
}