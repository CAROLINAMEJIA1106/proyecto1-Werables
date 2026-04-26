/**
 * Define las rutas de navegación de la aplicación utilizando Navigation 3.
 *
 * Se utiliza una sealed interface para representar cada pantalla como un tipo,
 * permitiendo navegación tipada y segura entre pantallas.
 */
package com.appmundial.presentation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable

@Serializable
sealed interface Routes : NavKey {

    /* Pantalla de inicio de la aplicación */
    @Serializable
    data object Inicio : Routes

    /* Pantalla de listado de paises ganadores */
    @Serializable
    data object Lista : Routes

    /**
     * Pantalla de detalle de un país.
     * Recibe el id del país seleccionado.
     */
    @Serializable
    data class Detalle(val paisId: Int) : Routes

    /**
     * Pantalla de integrantes del equipo campeón.
     * Recibe el id del campeonato.
     */
    @Serializable
    data class Integrantes(val campeonatoId: Int  , val title: String) : Routes
}
