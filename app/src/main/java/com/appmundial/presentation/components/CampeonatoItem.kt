package com.appmundial.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.appmundial.domain.data.local.entity.CampeonatoEntity

/**
 * Componente reutilizable que muestra la información de un campeonato.
 *
 * Se utiliza en listas para representar:
 * - Año del campeonato
 * - Goleador
 * - País del goleador
 * - Número de goles
 *
 * Permite navegación mediante click.
 */
@Composable
fun CampeonatoItem(
    campeonato: CampeonatoEntity,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },

        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            // Año
            Text(
                text = "⚽ Año: ${campeonato.ca_anio}",
                style = MaterialTheme.typography.titleMedium
            )

            campeonato.ca_goleador?.let {
                Text(text = "👤 Goleador: $it")
            }

            campeonato.ca_gole_pais?.let {
                Text(text = "🌍 País: $it")
            }

            campeonato.ca_gole_num_gol?.let {
                Text(text = "🥅 Goles: $it")
            }
        }
    }
}