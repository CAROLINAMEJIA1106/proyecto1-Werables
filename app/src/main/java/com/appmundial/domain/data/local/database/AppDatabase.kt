package com.appmundial.domain.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.appmundial.domain.data.local.dao.CampeonatoDao
import com.appmundial.domain.data.local.dao.IntegranteDao
import com.appmundial.domain.data.local.dao.PaisGanadorDao
import com.appmundial.domain.data.local.entity.CampeonatoEntity
import com.appmundial.domain.data.local.entity.IntegranteEntity
import com.appmundial.domain.data.local.entity.PaisGanadorEntity

@Database(
    entities = [
        PaisGanadorEntity::class,
        CampeonatoEntity::class,
        IntegranteEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun paisGanadorDao(): PaisGanadorDao
    abstract fun campeonatoDao(): CampeonatoDao
    abstract fun integranteDao(): IntegranteDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "cam_mundial.db"
                )
                    // Cargar la base de datos desde el archivo .db
                    .createFromAsset("cam_mundial.db")
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}