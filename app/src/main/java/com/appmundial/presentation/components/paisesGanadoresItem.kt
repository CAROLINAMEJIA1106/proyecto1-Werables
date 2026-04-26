package com.appmundial.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.appmundial.domain.data.local.entity.PaisGanadorEntity

@Composable

fun paisGanadorItem(
    paisGanador: PaisGanadorEntity,
    onClick: () -> Unit
)
{
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },

        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    )
    {
        Column(modifier = Modifier.padding(16.dp))
        {
            Text( text = "Nombre: ${paisGanador.pa_nombre}",
                style = MaterialTheme.typography.titleSmall)
            Text(text = "Campeonatos: ${paisGanador.pa_num_campeon}")
            Text(text = "Años: ${paisGanador.pa_anios}")
            AsyncImage(
                model = paisGanador.pa_bandera,
                contentDescription = paisGanador.pa_nombre,
                modifier = Modifier.size(50.dp)
            )
        }
    }
}