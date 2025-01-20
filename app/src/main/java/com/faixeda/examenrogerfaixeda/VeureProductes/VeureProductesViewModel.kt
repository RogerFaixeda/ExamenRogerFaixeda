package com.faixeda.examenrogerfaixeda.VeureProductes

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.faixeda.examenrogerfaixeda.Repositori
import com.faixeda.examenrogerfaixeda.data.Producte

class VeureProductesViewModel : ViewModel() {
    //HAuria de ser MutableLiveData!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private var _llistat_productes: LiveData<List<Producte>>?=null
    val llistat_productes: LiveData<List<Producte>>?
        get()=_llistat_productes

    fun llistar_alumnes(context: Context) {
        _llistat_productes = Repositori.obtenirProducte(context)
    }
}