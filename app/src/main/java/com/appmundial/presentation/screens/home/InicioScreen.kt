package com.appmundial.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import com.appmundial.R

/**
 * Pantalla de inicio de la aplicación.
 *
 * Muestra:
 * - Logo de la app
 * - Título
 * - Botones de navegación
 */
@Composable
fun InicioScreen(
    onIngresar: () -> Unit,
    onSalir: () -> Unit
) {

    val amarillo = Color(0xFFFFC107)
    val azul = Color(0xFF0D47A1)
    val rojo = Color(0xFFD32F2F)

    val fondo = Brush.verticalGradient(
        colors = listOf(amarillo, azul, rojo)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            // LOGO + TÍTULO
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.iconomundialapp), // LOGO
                    contentDescription = "Logo App",
                    modifier = Modifier
                        .size(120.dp) // Ajuste de tamaño del logo
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Historia del Mundial",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Países con más copas",
                    fontSize = 18.sp,
                    color = Color.White
                )
            }

            // 🔘 BOTONES
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Button(
                    onClick = onIngresar,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = azul
                    )
                ) {
                    Text(
                        text = "Ingresar",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                OutlinedButton(
                    onClick = onSalir,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Salir",
                        fontSize = 16.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}