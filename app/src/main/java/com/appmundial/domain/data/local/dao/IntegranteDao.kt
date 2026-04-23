package com.appmundial.domain.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.appmundial.domain.data.local.entity.IntegranteEntity

/*Interface Dao de la tabla integrante*/
@Dao
interface IntegranteDao {

    @Query("SELECT * FROM integrante WHERE int_ca_id = :campeonatoId")
    suspend fun getIntegrantesByCampeonato(campeonatoId: Int): List<IntegranteEntity>

    @Query("SELECT * FROM integrante WHERE int_ca_id = :campeonatoId AND int_es_jug = 1")
    suspend fun getJugadores(campeonatoId: Int): List<IntegranteEntity>
}