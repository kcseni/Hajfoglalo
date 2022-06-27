package hu.bme.aut.hajfoglalo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ServiceItem::class], version = 1, exportSchema = false)

abstract class ServiceItemDatabase : RoomDatabase() {
    abstract fun serviceItemDao(): ServiceItemDao

    companion object {

        @Volatile
        private var INSTANCE: ServiceItemDatabase? = null

        fun getDatabase(applicationContext: Context): ServiceItemDatabase {
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    applicationContext,
                    ServiceItemDatabase::class.java,
                    "service-item"
                ).build();

                INSTANCE=instance
                return instance
            }


        }
    }
}
