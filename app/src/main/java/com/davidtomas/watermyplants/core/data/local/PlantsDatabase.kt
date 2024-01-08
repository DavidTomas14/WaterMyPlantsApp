package com.davidtomas.watermyplants.core.data.local

import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.davidtomas.watermyplants.core.data.local.entity.PlantEntity

@Database(
    entities = [PlantEntity::class],
    version = 1
)
@TypeConverters(RoomTypeConverters::class)
abstract class PlantsDatabase : RoomDatabase() {

    abstract val dao: PlantsDao
}