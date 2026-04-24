package com.appmundial.domain.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.appmundial.domain.data.local.entity.PaisGanadorEntity

/**
 * DAO (Data Access Object) para la entidad PaisGanador.
 *
 * Proporciona métodos de acceso a la base de datos para consultar
 * los países ganadores del mundial.
 *
 * Actualmente implementa operaciones de solo lectura (SELECT),
 * ya que la aplicación funciona como sistema de consulta.
 */
@Dao
interface PaisGanadorDao {

    @Query("SELECT * FROM pais_ganador ORDER BY pa_num_campeon DESC")
    suspend fun getPaises(): List<PaisGanadorEntity>

    @Query("SELECT * FROM pais_ganador WHERE pa_id = :id")
    suspend fun getPaisById(id: Int): PaisGanadorEntity?
}