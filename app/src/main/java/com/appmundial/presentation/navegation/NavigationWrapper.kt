package com.appmundial.presentation.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.appmundial.domain.data.local.database.AppDatabase
import com.appmundial.presentation.screens.home.InicioScreen
import com.appmundial.presentation.screens.detalle.DetallePaisScreen
import com.appmundial.presentation.screens.detalle.DetallePaisViewModel

import com.appmundial.presentation.screens.paises.ListaPaisesScreen
import com.appmundial.presentation.screens.paises.ListaPaisesViewModel

import com.appmundial.presentation.screens.integrantes.IntegrantesScreen
import com.appmundial.presentation.screens.integrantes.IntegrantesViewModel
import android.util.Log
import kotlin.math.log


/**
 * Composable encargado de gestionar la navegación de la aplicación utilizando Navigation 3.
 *
 * Controla el flujo entre:
 * - Inicio
 * - Detalle de país
 *
 * Inyecta la base de datos en los ViewModel siguiendo MVVM.
 */
@Composable
fun NavigationWrapper(db: AppDatabase) {

    val backStack = rememberNavBackStack(Routes.Inicio)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },

        entryProvider = entryProvider {

            //  INICIO
            entry<Routes.Inicio> {
                val context = LocalContext.current
                val activity = context as? Activity
                InicioScreen(
                    onIngresar = {
                        // 🔥 temporal: país 1 (luego vendrá desde lista)
                        //backStack.add(Routes.Detalle(1))
                        backStack.add(Routes.Lista)
                    },
                    onSalir = {
                        activity?.finish()
                    }
                )
            }

            //  DETALLE PAÍS
            entry<Routes.Detalle> { route ->


                val detalleViewModel = viewModel<DetallePaisViewModel> {
                    DetallePaisViewModel(
                        db.campeonatoDao(),
                        db.paisGanadorDao()
                    )
                }

                DetallePaisScreen(
                    viewModel = detalleViewModel,
                    paisId = route.paisId,
                    onAnioClick = { campeonatoId , anio ->

                        val titulo = "${detalleViewModel.pais.value?.pa_nombre} - $anio "

                        backStack.add(
                            Routes.Integrantes(
                                campeonatoId = campeonatoId,
                                title = titulo
                            )
                        )
                    },
                    onInicio = { backStack.add(Routes.Inicio) },
                    onBack = { backStack.removeLastOrNull() }
                )
            }


            entry<Routes.Integrantes> { route ->
                val viewModel = viewModel<IntegrantesViewModel> {
                    IntegrantesViewModel(
                        db.integranteDao()
                    )
                }

                IntegrantesScreen(
                    viewModel = viewModel,
                    campeonatoId = route.campeonatoId,
                    title = route.title,
                    onBack = { backStack.removeLastOrNull() },
                    onInicio = { backStack.add(Routes.Inicio) }
                )
            }



            //Lista de paises ganadores
            entry<Routes.Lista> { route ->
                val ListaPaisesViewModel = viewModel<ListaPaisesViewModel> {
                    ListaPaisesViewModel(
                        db.paisGanadorDao()
                    )
                }
                ListaPaisesScreen(
                    viewModel = ListaPaisesViewModel,
                    onItemClick= {paisId ->backStack.add(Routes.Detalle(paisId))},
                    onInicio = { backStack.add(Routes.Inicio) },
                    onBack = { backStack.removeLastOrNull() }
                )
            }
        }
    )
}