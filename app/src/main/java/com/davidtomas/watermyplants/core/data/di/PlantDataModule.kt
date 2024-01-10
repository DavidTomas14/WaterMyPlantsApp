package com.davidtomas.watermyplants.core.data.di

import android.app.Application
import androidx.room.Room
import com.davidtomas.watermyplants.core.data.local.PlantsDatabase
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
    fun providePlantsDatabase(app: Application): PlantsDatabase {
        return Room.databaseBuilder(
            app,
            PlantsDatabase::class.java,
            "plant_db"
        ).build()
    }
}