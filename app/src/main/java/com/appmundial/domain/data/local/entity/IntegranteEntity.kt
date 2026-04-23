package com.appmundial.domain.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "integrante")
data class IntegranteEntity (
    @PrimaryKey(autoGenerate = true)
    val int_id: Int,

    val int_ca_id: Int,   // FK → campeonato

    val int_nombre: String,

    val int_es_jug: Int   // 1 = jugador
)