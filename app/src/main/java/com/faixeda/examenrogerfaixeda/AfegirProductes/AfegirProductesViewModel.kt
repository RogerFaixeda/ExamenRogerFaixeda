package com.faixeda.examenrogerfaixeda.AfegirProductes

import android.content.Context
import androidx.lifecycle.ViewModel
import com.faixeda.examenrogerfaixeda.Repositori
import com.faixeda.examenrogerfaixeda.data.Producte

class AfegirProductesViewModel : ViewModel() {
    fun nouProducte(context: Context, nom : String, preu : Int){
        var producteVM = Producte(nom, preu)
        Repositori.afegirProducte(context,producteVM)
    }
}