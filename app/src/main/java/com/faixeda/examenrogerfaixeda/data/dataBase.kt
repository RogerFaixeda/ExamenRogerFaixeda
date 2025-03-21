package com.faixeda.examenrogerfaixeda.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Producte::class],
    version = 1,
    exportSchema = false
)

abstract class dataBase : RoomDatabase(){
    abstract fun producteDao() : ProducteDAO
    companion object{
        @Volatile
        private var INSTANCE : dataBase? = null
        fun getDatabase(context: Context) : dataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null){
                synchronized(this){
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }

        //        Aixo s'ha de fer servir per quan tingui feta la populacio de la base de dades
        private fun buildDatabase(context: Context): dataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                dataBase::class.java,
                "productes_database"
            ).createFromAsset("databases/productes_database.db").build()
        }

//        fun buildDatabase(context: Context) : dataBase {
//            return Room.databaseBuilder(
//                context.applicationContext,
//                dataBase::class.java,
//                "productes_database"
//            ).build()
//        }
    }
}