package com.faixeda.examenrogerfaixeda.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Producte(
    var nom : String,
    var preu : Int,
){
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}