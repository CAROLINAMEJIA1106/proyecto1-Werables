package com.appmundial.domain.data.local.entity

import androidx.room.Entity
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
@Entity(tableName = "integrante")
data class IntegranteEntity (
    @PrimaryKey(autoGenerate = true)
    val int_id: Int,

    val int_ca_id: Int,   // FK → campeonato

    val int_nombre: String,

    val int_es_jug: Int   // 1 = jugador
)