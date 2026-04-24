package com.appmundial.domain.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
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

@Entity(
    tableName = "campeonato",
    foreignKeys = [
        ForeignKey(
            entity = PaisGanadorEntity::class,
            parentColumns = ["pa_id"],
            childColumns = ["ca_pa_id"],
            onDelete = ForeignKey.NO_ACTION
        )
    ]
)
data class CampeonatoEntity(

    @PrimaryKey
    @ColumnInfo(name = "ca_id")
    val ca_id: Int,

    @ColumnInfo(name = "ca_pa_id")
    val ca_pa_id: Int,

    @ColumnInfo(name = "ca_anio")
    val ca_anio: Int,

    @ColumnInfo(name = "ca_goleador")
    val ca_goleador: String?,

    @ColumnInfo(name = "ca_gole_pais")
    val ca_gole_pais: String?,

    @ColumnInfo(name = "ca_gole_num_gol")
    val ca_gole_num_gol: Int?,

    @ColumnInfo(name = "ca_gole_img")
    val ca_gole_img: String?
)

