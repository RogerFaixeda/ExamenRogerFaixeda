package com.faixeda.examenrogerfaixeda

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faixeda.examenrogerfaixeda.data.Producte

class SharedViewModel : ViewModel() {
    private var _producte = MutableLiveData<Producte>()
    val producte: LiveData<Producte> = _producte

    fun setProducte(productee: MutableLiveData<Producte>){
        _producte = productee
    }

}