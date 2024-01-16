package com.davidtomas.watermyplants.features.add_edit.domain.di

import com.davidtomas.watermyplants.core.domain.repository.PlantRepository
import com.davidtomas.watermyplants.features.add_edit.domain.use_case.AddEditPlantUseCase
import com.davidtomas.watermyplants.features.add_edit.domain.use_case.GetPlantByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object AddEditPlantDomainModule {
    @ViewModelScoped
    @Provides
    fun provideAddPlantUseCase(
        repository: PlantRepository
    ): AddEditPlantUseCase = AddEditPlantUseCase(plantRepository = repository)

    @ViewModelScoped
    @Provides
    fun provideGetPlantByIdUseCase(
        repository: PlantRepository
    ): GetPlantByIdUseCase = GetPlantByIdUseCase(plantRepository = repository)
}