package com.faixeda.examenrogerfaixeda.ModificarProductes

import android.content.Context
import android.content.LocusId
import androidx.lifecycle.ViewModel
import com.faixeda.examenrogerfaixeda.Repositori
import com.faixeda.examenrogerfaixeda.data.Producte

class ModificarProductesViewModel : ViewModel() {
    fun modificaProducte(context: Context, nom : String, preu : Int){
        var producteVM = Producte(nom, preu)
        Repositori.modificarProducte(context,nom, preu)
    }
    fun eliminarProducte(context: Context, nom : String, preu : Int){
        var producteVM = Producte(nom, preu)
        Repositori.eliminarProducte(context,nom, preu)
    }


}