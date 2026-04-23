package com.appmundial.domain.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entidad que representa la tabla 'campeonato' en la base de datos.
 *
 * Contiene la información de cada campeonato ganado por un país, incluyendo:
 * - Año del campeonato
 * - Relación con el país ganador (clave foránea)
 * - Información del goleador (nombre, país, número de goles, imagen)
 *
 * Esta entidad permite relacionar los países con sus campeonatos ganados.
 */
@Entity(tableName = "campeonato")
data class CampeonatoEntity (
    @PrimaryKey(autoGenerate = true)
    val ca_id: Int,

    val ca_pa_id: Int,   // FK → pais_ganador

    val ca_anio: Int,

    val ca_goleador: String?,

    val ca_gole_pais: String?,

    val ca_gole_num_gol: Int?,

    val ca_gole_img: String?
)