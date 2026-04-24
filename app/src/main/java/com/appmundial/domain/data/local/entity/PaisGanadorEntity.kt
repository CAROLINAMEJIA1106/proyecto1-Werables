package com.appmundial.domain.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Entidad que representa la tabla 'pais_ganador' en la base de datos SQLite.
 *
 * Esta clase almacena la información de los países que han ganado la copa mundial,
 * incluyendo su identificador, nombre, número de campeonatos ganados, bandera (imagen en formato BLOB)
 * y los años en los que ha sido campeón.
 *
 * Es utilizada por Room para mapear los datos de la base de datos a objetos Kotlin.
 */

@Entity(tableName = "pais_ganador")
data class PaisGanadorEntity (
    @PrimaryKey(autoGenerate = true)
    val pa_id: Int,

    val pa_nombre: String,

    val pa_num_campeon: Int,

    val pa_bandera: ByteArray?,   // BLOB

    val pa_anios: String?
)