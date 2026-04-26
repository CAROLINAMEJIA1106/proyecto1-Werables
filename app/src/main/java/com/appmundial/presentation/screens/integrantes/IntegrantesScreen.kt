package com.appmundial.presentation.screens.integrantes

import android.R.attr.padding
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.appmundial.presentation.components.AppScaffold
import androidx.compose.foundation.lazy.items
import com.appmundial.presentation.components.IntegranteItem

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding

@Composable
fun IntegrantesScreen(
        viewModel: IntegrantesViewModel,
        campeonatoId: Int,
        title: String,
        onBack: () -> Unit,
        onInicio: () -> Unit
) {

        // Estado del ViewModel
        val integrantes by viewModel.integrantes.collectAsState(initial = emptyList())

        // Cargar datos
        LaunchedEffect(campeonatoId) {
                viewModel.cargarIntegrantes(campeonatoId)
        }


        AppScaffold(
                title = title,
                onBackClick = onBack,
                onHomeClick = onInicio
        ) { modifier ->

                LazyColumn(
                        modifier = Modifier
                                .fillMaxSize()
                                .padding(modifier),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                        items(integrantes) { integrante ->

                                //Log.d("DEBUG", "ID: $integrante")

                                IntegranteItem(
                                        nombre = integrante.int_nombre,
                                        esJugador = integrante.int_es_jug

                                )
                        }
                        /*items(integrantes) { integrante ->
                                Text(
                                        text = integrante.int_nombre,
                                        modifier = Modifier.padding(16.dp)
                                )
                        }*/
                        /*items(integrantes) { integrante ->
                                Text(
                                        text = integrante.nombre,
                                        modifier = Modifier.padding(16.dp)
                                )
                        }*/


                }
        }
}