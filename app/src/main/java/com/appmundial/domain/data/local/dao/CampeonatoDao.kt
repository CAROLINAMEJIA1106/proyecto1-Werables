package com.appmundial.domain.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.appmundial.domain.data.local.entity.CampeonatoEntity

/*Clase para manejar los datos de los equipos campeones*/
@Dao
interface CampeonatoDao {

    @Query("SELECT * FROM campeonato WHERE ca_pa_id = :paisId ORDER BY ca_anio")
    suspend fun getCampeonatosByPais(paisId: Int): List<CampeonatoEntity>
}