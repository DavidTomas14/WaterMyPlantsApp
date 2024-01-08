package com.davidtomas.watermyplants.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class PlantWaterHistoryEntity(
    @PrimaryKey val id: Int? = null,
    val idPlant: Int,
    val wateredDate: String
)
