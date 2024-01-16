package com.davidtomas.watermyplants.features.home.domain.use_case

import com.davidtomas.watermyplants.core.domain.repository.PlantRepository
import com.davidtomas.watermyplants.features.home.domain.model.PlantModel

class DeletePlantUseCase(
    private val repository: PlantRepository
) {
    suspend operator fun  invoke(plant: PlantModel) {
        return repository.deletePlant(plant)
    }
}