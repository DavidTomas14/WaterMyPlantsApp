package com.davidtomas.watermyplants.core.domain.repository

import com.davidtomas.watermyplants.features.add_edit.domain.model.AddEditPlantModel
import com.davidtomas.watermyplants.features.home.domain.model.PlantModel
import kotlinx.coroutines.flow.Flow

interface PlantRepository {
    suspend fun insertPlant(addEditPlantModel: AddEditPlantModel)
    suspend fun deletePlant(plantModel: PlantModel)
    fun getPlants(): Flow<List<PlantModel>>
    fun getPlantById(idPlant: Int): Flow<PlantModel>

}