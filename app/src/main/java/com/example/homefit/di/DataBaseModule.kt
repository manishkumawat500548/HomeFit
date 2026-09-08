package com.example.homefit.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.homefit.data.local.WorkoutDao
import com.example.homefit.data.local.WorkoutDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    val migration = object : Migration(1, 2) {
        override fun migrate(db: SupportSQLiteDatabase) {
            db.execSQL("ALTER TABLE workout_session ADD COLUMN date TEXT NOT NULL DEFAULT ''")
        }
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): WorkoutDatabase {

        return Room.databaseBuilder(
            context,
            WorkoutDatabase::class.java,
            "workout_database"
        ).addMigrations(migration).build()
    }

    @Provides
    @Singleton
    fun provideWorkoutDao(
        database: WorkoutDatabase
    ): WorkoutDao {

        return database.workoutDao()
    }
}