package com.appmundial.presentation.screens.detalle

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
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
    onAnioClick: (Int) -> Unit,
    onInicio: () -> Unit,
    onBack: () -> Unit
) {

    //  Estados desde el ViewModel
    val campeonatos by viewModel.campeonatos.collectAsState()
    val pais by viewModel.pais.collectAsState()

    //  Cargar datos
    LaunchedEffect(paisId) {
        viewModel.cargarDatos(paisId)
    }

    //  ESTRUCTURA PRINCIPAL CON SCAFFOLD
    AppScaffold(
        title = pais?.pa_nombre ?: "Detalle del país",
        onBackClick = onBack,
        onHomeClick = onInicio
    ) { padding ->

        LazyColumn(
            modifier = padding
        ) {

            items(campeonatos) { campeonato ->

                CampeonatoItem(
                    campeonato = campeonato,
                    onClick = {
                        onAnioClick(campeonato.ca_id)
                    }
                )
            }
        }
    }
}