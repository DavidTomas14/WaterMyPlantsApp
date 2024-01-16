package com.davidtomas.watermyplants.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlantEntity(
    val name: String,
    val description: String,
    val water: String,
    val wateringDates: String,
    val alreadyWateredDated: String,
    val time: String,
    val imageUrl: String,
    @PrimaryKey val id: Int? = null
)
