package com.appmundial.presentation.screens.detalle


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import android.util.Log

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.appmundial.presentation.components.CampeonatoItem
import com.appmundial.presentation.components.AppScaffold

/**
 * Pantalla que muestra el detalle de un país:
 * - Nombre del país
 * - Lista de campeonatos ganados
 * - Navegación hacia integrantes
 */
@Composable
fun DetallePaisScreen(
    viewModel: DetallePaisViewModel,
    paisId: Int,
    onAnioClick: (Int, Int) -> Unit,
    onInicio: () -> Unit,
    onBack: () -> Unit
) {

    //  Estados desde el ViewModel
    val campeonatos by viewModel.campeonatos.collectAsState()
    val pais by viewModel.pais.collectAsState()

    //  Cargar datos
    LaunchedEffect(Unit) {
        viewModel.cargarDatos(paisId)
    }

    //  ESTRUCTURA PRINCIPAL CON SCAFFOLD
    AppScaffold(
        title = pais?.pa_nombre ?: "Detalle del país",
        onBackClick = onBack,
        onHomeClick = onInicio
    ) { padding ->

        LazyColumn(
            //modifier = padding
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(campeonatos) { campeonato ->
                //Log.d("DEBUG", "ID: $campeonato")
                CampeonatoItem(
                    campeonato = campeonato,
                    onClick = {
                        onAnioClick(campeonato.ca_id, campeonato.ca_anio)
                    }
                )
            }
        }
    }
}