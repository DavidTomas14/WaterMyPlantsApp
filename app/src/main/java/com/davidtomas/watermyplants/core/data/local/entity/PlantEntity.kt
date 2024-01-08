package com.davidtomas.watermyplants.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlantEntity(
    val name: String,
    val description: String,
    val water: String,
    var needsWater: Boolean,
    val date: String,
    val imageUrl: String,
    val plantStatus: String,
    @PrimaryKey val id: Int? = null
)
