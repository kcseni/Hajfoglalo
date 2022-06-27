package hu.bme.aut.hajfoglalo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AppointmentInfo::class], version = 1, exportSchema = false)

abstract class AppointmentInfoDatabase : RoomDatabase() {
    abstract fun appointmentInfoDao(): AppointmentInfoDao

    companion object {

        @Volatile
        private var INSTANCE: AppointmentInfoDatabase? = null

        fun getDatabase(applicationContext: Context): AppointmentInfoDatabase {
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    applicationContext,
                    AppointmentInfoDatabase::class.java,
                    "appointment-info"
                ).build();

                INSTANCE=instance
                return instance
            }


        }
    }
}