package com.appmundial.presentation.screens.integrantes

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.appmundial.presentation.components.AppScaffold
import androidx.compose.foundation.lazy.items
import com.appmundial.presentation.components.IntegranteItem

@Composable
fun IntegrantesScreen(
        viewModel: IntegrantesViewModel,
        campeonatoId: Int,
        title: String,
        onBack: () -> Unit,
        onInicio: () -> Unit
) {

        // Estado del ViewModel
        val integrantes by viewModel.integrantes.collectAsState()

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
                        modifier = modifier
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