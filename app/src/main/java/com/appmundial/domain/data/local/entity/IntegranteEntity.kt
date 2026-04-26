package com.appmundial.domain.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


/**
 * Entidad que representa la tabla 'integrante' en la base de datos.
 *
 * Contiene la información de los integrantes de un equipo campeón en un campeonato específico,
 * incluyendo jugadores y otros miembros asociados.
 *
 * El campo 'int_es_jug' permite identificar si el integrante es jugador (1) u otro tipo.
 *
 * Está relacionada con la tabla 'campeonato' mediante una clave foránea.
 */

@Entity(
    tableName = "integrante",
    foreignKeys = [
        ForeignKey(
            entity = CampeonatoEntity::class,
            parentColumns = ["ca_id"],
            childColumns = ["int_ca_id"],
            onDelete = ForeignKey.NO_ACTION
        )
    ]
)
data class IntegranteEntity(

    @PrimaryKey
    @ColumnInfo(name = "int_id")
    val int_id: Int,

    @ColumnInfo(name = "int_ca_id")
    val int_ca_id: Int?,   // 🔥 nullable (porque BD lo permite)

    @ColumnInfo(name = "int_nombre")
    val int_nombre: String,

    @ColumnInfo(name = "int_es_jug")
    val int_es_jug: Int?   // 🔥 nullable (porque BD lo permite)
) {
}

