/*View Model para manejar la tabla de paises ganadores del mundial*/
package com.appmundial.presentation.screens.paises
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appmundial.domain.data.local.dao.PaisGanadorDao
import com.appmundial.domain.data.local.entity.PaisGanadorEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListaPaisesViewModel (
    private val paisCampeonDao: PaisGanadorDao
) : ViewModel()
{
    //Lista de paises ganadores del mundial
    private val _paises = MutableStateFlow<List<PaisGanadorEntity>>(emptyList())
    val paises: StateFlow<List<PaisGanadorEntity>> = _paises.asStateFlow()

    //Funcion para traer la lista de paises ganadores
    fun traerPaises(){
        viewModelScope.launch(Dispatchers.IO){
            _paises.value = paisCampeonDao.getPaises()
        }
    }
}