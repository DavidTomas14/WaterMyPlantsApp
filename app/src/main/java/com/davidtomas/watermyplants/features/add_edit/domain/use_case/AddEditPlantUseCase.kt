package com.davidtomas.watermyplants.features.add_edit.domain.use_case

import com.davidtomas.watermyplants.core.domain.repository.PlantRepository
import com.davidtomas.watermyplants.features.add_edit.domain.model.AddEditPlantModel

class AddEditPlantUseCase(
    private val plantRepository: PlantRepository
) {
    suspend operator fun invoke(params: AddEditPlantModel) {
        plantRepository.insertPlant(params)
    }
}