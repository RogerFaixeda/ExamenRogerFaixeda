package com.faixeda.examenrogerfaixeda

import android.content.Context
import androidx.lifecycle.LiveData
import com.faixeda.examenrogerfaixeda.data.Producte
import com.faixeda.examenrogerfaixeda.data.dataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class Repositori {
    companion object{
        var repositori_database: dataBase? = null

        var productes: LiveData<List<Producte>>? = null

        //funció per a inicialitzar la BD

        fun initializeDB(context: Context): dataBase {
            return dataBase.getDatabase(context)
        }

        //TODO:funcio qyue cridi a l'insert

        fun afegirProducte(context: Context, producte: Producte) {

            //Connectar la BD
            repositori_database = initializeDB(context)

            CoroutineScope(IO).launch {
                repositori_database!!.producteDao().afegirProducte(producte)
            }
        }

        //TODO:funcio que torni la select

        fun obtenirProducte(context: Context): LiveData<List<Producte>>? {
            //Connectar la BD
            repositori_database = initializeDB(context)

            CoroutineScope(IO).launch {
                productes = repositori_database!!.producteDao().obtenirProducte()
            }

            return productes

        }

        fun modificarProducte(context: Context, nom : String, preu : Int){
            repositori_database = initializeDB(context)

            CoroutineScope(IO).launch {
                repositori_database!!.producteDao().modificarProducte(nom , preu )
            }
        }

        fun eliminarProducte(context: Context, nom : String, preu : Int){
            repositori_database = initializeDB(context)

            CoroutineScope(IO).launch {
                repositori_database!!.producteDao().deleteProducte(nom , preu)
            }
        }
    }
}