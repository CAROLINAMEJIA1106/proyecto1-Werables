package com.appmundial.domain.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


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