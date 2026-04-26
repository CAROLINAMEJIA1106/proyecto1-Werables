package com.appmundial.presentation.screens.integrantes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appmundial.domain.data.local.dao.IntegranteDao
import com.appmundial.domain.data.local.entity.IntegranteEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class IntegrantesViewModel(
    private val integranteDao: IntegranteDao
) : ViewModel() {

    // Lista de integrantes
    private val _integrantes = MutableStateFlow<List<IntegranteEntity>>(emptyList())
    val integrantes: StateFlow<List<IntegranteEntity>> = _integrantes

    /**
     * Cargar integrantes por campeonato
     */
    fun cargarIntegrantes(campeonatoId: Int) {
        viewModelScope.launch {
            _integrantes.value = integranteDao.getIntegrantesByCampeonato(campeonatoId)
        }
    }
}