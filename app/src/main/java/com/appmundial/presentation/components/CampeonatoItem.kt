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

import coil.compose.AsyncImage
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp



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

        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // TEXTO (IZQUIERDA)
            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(text = "🏆 Año: ${campeonato.ca_anio}")
                Text(text = "👤 Goleador: ${campeonato.ca_goleador}")
                Text(text = "🌍 País del goleador: ${campeonato.ca_gole_pais}")
                Text(text = "⚽ Goles: ${campeonato.ca_gole_num_gol}")
            }

            // IMAGEN (DERECHA)
            campeonato.ca_gole_img?.let { url ->

                Spacer(modifier = Modifier.width(12.dp))

                AsyncImage(
                    model = url,
                    contentDescription = "Goleador",
                    modifier = Modifier
                        .size(70.dp)

                )
            }
        }
    }
}