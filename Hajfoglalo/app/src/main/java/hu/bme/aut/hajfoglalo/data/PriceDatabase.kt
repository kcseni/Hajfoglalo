package hu.bme.aut.hajfoglalo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Price::class], version = 1, exportSchema = false)

abstract class PriceDatabase : RoomDatabase() {
    abstract fun priceDao(): PriceDao

    companion object {

        @Volatile
        private var INSTANCE: PriceDatabase? = null

        fun getDatabase(applicationContext: Context): PriceDatabase {
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    applicationContext,
                    PriceDatabase::class.java,
                    "price"
                ).build();

                INSTANCE=instance
                return instance
            }


        }
    }
}