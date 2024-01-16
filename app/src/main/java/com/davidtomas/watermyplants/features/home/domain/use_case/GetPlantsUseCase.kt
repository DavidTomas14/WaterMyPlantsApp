package com.davidtomas.watermyplants.features.home.domain.use_case

import com.davidtomas.watermyplants.core.domain.repository.PlantRepository
import com.davidtomas.watermyplants.features.home.domain.model.PlantModel
import kotlinx.coroutines.flow.Flow

class GetPlantsUseCase(
    private val repository: PlantRepository
) {
    operator fun  invoke() : Flow<List<PlantModel>> {
        return repository.getPlants()
    }
}