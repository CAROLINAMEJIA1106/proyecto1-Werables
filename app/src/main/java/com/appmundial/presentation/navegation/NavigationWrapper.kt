package com.appmundial.presentation.navegation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.appmundial.domain.data.local.database.AppDatabase


@Composable
fun NavigationWrapper(db: AppDatabase) {

    val backStack = rememberNavBackStack<Routes>(Routes.Inicio)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {

            // LISTA PAISES
            entry<Routes.Lista> {

                val vm = viewModel<ListPaisesViewModel> {
                    ListPaisesViewModel(db.paisGanadorDao())
                }

                ListaPaisesScreen(
                    viewModel = vm,
                    onPaisClick = { id ->
                        backStack.add(Routes.Detalle(id))
                    },
                    onInicio = { backStack.add(Routes.Inicio) },
                    onBack = { backStack.removeLastOrNull() }
                )
            }
        }
    )
}