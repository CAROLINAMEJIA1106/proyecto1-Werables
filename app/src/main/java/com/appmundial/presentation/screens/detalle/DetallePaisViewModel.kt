package com.appmundial.presentation.screens.detalle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appmundial.domain.data.local.dao.CampeonatoDao
import com.appmundial.domain.data.local.dao.PaisGanadorDao
import com.appmundial.domain.data.local.entity.CampeonatoEntity
import com.appmundial.domain.data.local.entity.PaisGanadorEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel encargado de gestionar la lógica de la pantalla de detalle de un país.
 *
 * Obtiene:
 * - Los campeonatos asociados al país
 * - La información del país seleccionado
 *
 * Expone los datos a la UI mediante StateFlow.
 */
class DetallePaisViewModel(
    private val campeonatoDao: CampeonatoDao,
    private val paisDao: PaisGanadorDao
) : ViewModel() {

    // Lista de campeonatos del país
    private val _campeonatos = MutableStateFlow<List<CampeonatoEntity>>(emptyList())
    val campeonatos: StateFlow<List<CampeonatoEntity>> = _campeonatos

    // Información del país
    private val _pais = MutableStateFlow<PaisGanadorEntity?>(null)
    val pais: StateFlow<PaisGanadorEntity?> = _pais

    /**
     * Carga TODOS los datos necesarios para la pantalla:
     * - Campeonatos
     * - País
     */
    fun cargarDatos(paisId: Int) {
        viewModelScope.launch {

            // Traer campeonatos filtrados por país
            _campeonatos.value = campeonatoDao.getCampeonatosByPais(paisId)

            // Traer información del país
            _pais.value = paisDao.getPaisById(paisId)
        }
    }
}