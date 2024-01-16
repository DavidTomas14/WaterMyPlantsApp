package com.davidtomas.watermyplants.core.data.di

import android.app.Application
import androidx.room.Room
import com.davidtomas.watermyplants.core.data.local.PlantDatabase
import com.davidtomas.watermyplants.core.data.repository.PlantRepositoryImpl
import com.davidtomas.watermyplants.core.domain.repository.PlantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PlantDataModule {
    @Provides
    @Singleton
    fun providePlantsDatabase(app: Application): PlantDatabase {
        return Room.databaseBuilder(
            app,
            PlantDatabase::class.java,
            "plant_db"
        ).build()
    }

    @Provides
    @Singleton
    fun providePlantRepository(
        db: PlantDatabase
    ): PlantRepository {
        return PlantRepositoryImpl(db.dao)
    }
}