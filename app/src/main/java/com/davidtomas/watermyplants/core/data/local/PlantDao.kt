package com.davidtomas.watermyplants.core.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.davidtomas.watermyplants.core.data.local.entity.PlantEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlant(plantEntity: PlantEntity)

    @Delete
    suspend fun deletePlant(plantEntity: PlantEntity)

    @Query(
        """
            SELECT *
            FROM plantentity
        """
    )
    fun getPlants(): Flow<List<PlantEntity>>

    @Query(
        """
            SELECT *
            FROM plantentity
            WHERE id = :idPlant
        """
    )
    fun getPlantById(idPlant: Int): Flow<PlantEntity>
}
