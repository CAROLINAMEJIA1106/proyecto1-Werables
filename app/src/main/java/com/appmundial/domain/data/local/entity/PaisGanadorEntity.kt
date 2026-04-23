package com.appmundial.domain.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "pais_ganador")
data class PaisGanadorEntity (
    @PrimaryKey(autoGenerate = true)
    val pa_id: Int,

    val pa_nombre: String,

    val pa_num_campeon: Int,

    val pa_bandera: ByteArray?,   // BLOB

    val pa_anios: String
)