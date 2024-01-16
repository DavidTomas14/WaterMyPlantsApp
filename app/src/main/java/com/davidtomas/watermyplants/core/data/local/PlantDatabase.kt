package com.davidtomas.watermyplants.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.davidtomas.watermyplants.core.data.local.entity.PlantEntity

@Database(
    entities = [PlantEntity::class],
    version = 1
)
@TypeConverters(RoomTypeConverters::class)
abstract class PlantDatabase : RoomDatabase() {

    abstract val dao: PlantDao
}