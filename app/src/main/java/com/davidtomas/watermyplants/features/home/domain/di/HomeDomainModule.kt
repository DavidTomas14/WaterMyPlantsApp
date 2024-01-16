package com.davidtomas.watermyplants.features.home.domain.di

import com.davidtomas.watermyplants.core.domain.repository.PlantRepository
import com.davidtomas.watermyplants.features.home.domain.use_case.CalculateDaysOfWateringPerPlantUseCase
import com.davidtomas.watermyplants.features.home.domain.use_case.DeletePlantUseCase
import com.davidtomas.watermyplants.features.home.domain.use_case.GetPlantsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object HomeDomainModule {
    @ViewModelScoped
    @Provides
    fun provideGetPlantsUseCase(
        repository: PlantRepository
    ): GetPlantsUseCase = GetPlantsUseCase(repository = repository)

    @ViewModelScoped
    @Provides
    fun provideDeletePlantUseCase(
        repository: PlantRepository
    ): DeletePlantUseCase = DeletePlantUseCase(repository = repository)
    @ViewModelScoped
    @Provides
    fun provideCalculateDaysOfWateringUseCase(): CalculateDaysOfWateringPerPlantUseCase =
        CalculateDaysOfWateringPerPlantUseCase()
}