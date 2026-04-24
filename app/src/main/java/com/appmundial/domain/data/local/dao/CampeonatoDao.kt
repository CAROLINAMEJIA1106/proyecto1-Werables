package com.appmundial.domain.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.appmundial.domain.data.local.entity.CampeonatoEntity

/**
 * DAO para la entidad Campeonato.
 *
 * Permite obtener los campeonatos asociados a un país específico,
 * facilitando la consulta de los años en los que un país fue campeón.
 *
 * Se utiliza principalmente en la pantalla de detalle del país.
 */
@Dao
interface CampeonatoDao {

    @Query("SELECT * FROM campeonato WHERE ca_pa_id = :paisId ORDER BY ca_anio")
    suspend fun getCampeonatosByPais(paisId: Int): List<CampeonatoEntity>
}