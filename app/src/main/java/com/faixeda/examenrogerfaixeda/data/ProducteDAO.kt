package com.faixeda.examenrogerfaixeda.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProducteDAO {
    //Consultes
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun afegirProducte(producte: Producte)

    @Query("SELECT * FROM Producte ORDER BY preu DESC")
    fun obtenirProducte(): LiveData<List<Producte>>
}