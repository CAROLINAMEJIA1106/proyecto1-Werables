package com.appmundial.domain.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.appmundial.domain.data.local.entity.PaisGanadorEntity


@Dao
interface PaisGanadorDao {

    @Query("SELECT * FROM pais_ganador ORDER BY pa_num_campeon DESC")
    suspend fun getPaises(): List<PaisGanadorEntity>
}