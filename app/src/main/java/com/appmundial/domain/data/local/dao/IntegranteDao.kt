package com.appmundial.domain.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.appmundial.domain.data.local.entity.IntegranteEntity

/**
 * DAO para la entidad Integrante.
 *
 * Proporciona métodos para consultar los integrantes de un equipo
 * en un campeonato específico.
 *
 * Permite obtener tanto la lista completa de integrantes como filtrar
 * únicamente los jugadores mediante consultas específicas.
 */
@Dao
interface IntegranteDao {

    @Query("SELECT * FROM integrante WHERE int_ca_id = :campeonatoId")
    suspend fun getIntegrantesByCampeonato(campeonatoId: Int): List<IntegranteEntity>

    @Query("SELECT * FROM integrante WHERE int_ca_id = :campeonatoId AND int_es_jug = 1")
    suspend fun getJugadores(campeonatoId: Int): List<IntegranteEntity>
}