package com.davidtomas.watermyplants.core.data.local.mapper

import com.davidtomas.watermyplants.core.data.local.entity.PlantEntity
import com.davidtomas.watermyplants.features.home.domain.model.Plant
import com.davidtomas.watermyplants.features.home.domain.model.PlantStatus

fun PlantEntity.toPlant(): Plant {
    return Plant(
        name = name,
        description = description,
        water = water,
        needsWater = needsWater,
        time = date,
        imageUrl = imageUrl,
        plantStatus = PlantStatus.fromString(plantStatus)
    )
}

fun Plant.toPlant(): PlantEntity {
    return PlantEntity(
        name = name,
        description = description,
        water = water,
        needsWater = needsWater,
        date = time,
        imageUrl = imageUrl,
        plantStatus = plantStatus.name
    )
}