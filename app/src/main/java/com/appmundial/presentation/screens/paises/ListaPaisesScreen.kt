/*
Pagina para visualizar el listado de paises que han ganado
un mundial de fútbol
*/
package com.appmundial.presentation.screens.paises
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.appmundial.presentation.components.AppScaffold
import com.appmundial.presentation.components.paisGanadorItem

@Composable
fun ListaPaisesScreen(
    viewModel: ListaPaisesViewModel,
    onItemClick: (Int) -> Unit,
    onInicio: () -> Unit,
    onBack: () -> Unit
)
{
    // Estados desde el viewModel
    val listPaises by viewModel.paises.collectAsState(initial = emptyList())
    //Cargamos los datos
    LaunchedEffect(Unit) { viewModel.traerPaises() }

    //Diseño de pantalla
    AppScaffold(title = "Mundiales de Futbol",
        onBackClick = onBack,
        onHomeClick = onInicio
    ){  padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        )
        {
            items(listPaises){pais ->
                paisGanadorItem(
                    paisGanador = pais,
                    onClick = { onItemClick(pais.pa_id) })
            }
        }
    }
}