package com.davidtomas.watermyplants.core.data.repository

import com.davidtomas.watermyplants.core.data.local.PlantDao
import com.davidtomas.watermyplants.core.data.local.mapper.toPlant
import com.davidtomas.watermyplants.core.data.local.mapper.toPlantEntity
import com.davidtomas.watermyplants.core.domain.repository.PlantRepository
import com.davidtomas.watermyplants.features.add_edit.domain.model.AddEditPlantModel
import com.davidtomas.watermyplants.features.home.domain.model.PlantModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PlantRepositoryImpl(
    private val dao: PlantDao
) : PlantRepository {
    override suspend fun insertPlant(plant: AddEditPlantModel) {
        dao.insertPlant(plant.toPlantEntity())
    }

    override suspend fun deletePlant(plantModel: PlantModel) {
        dao.deletePlant(plantModel.toPlantEntity())
    }

    override fun getPlants(): Flow<List<PlantModel>> {
        return dao.getPlants().map { plantEntityList ->
            plantEntityList.map { plantEntity ->
                plantEntity.toPlant()
            }
        }
    }

    override fun getPlantById(idPlant: Int): Flow<PlantModel> {
        return dao.getPlantById(idPlant).map { plantEntity ->
            plantEntity.toPlant()
        }
    }
}