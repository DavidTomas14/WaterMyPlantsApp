package com.davidtomas.watermyplants.features.add_edit.domain.use_case

import com.davidtomas.watermyplants.core.domain.repository.PlantRepository
import com.davidtomas.watermyplants.features.home.domain.model.PlantModel
import kotlinx.coroutines.flow.Flow

class GetPlantByIdUseCase(
    private val plantRepository: PlantRepository
) {
    operator fun invoke(idPlant: Int): Flow<PlantModel> {
        return plantRepository.getPlantById(idPlant)
    }
}