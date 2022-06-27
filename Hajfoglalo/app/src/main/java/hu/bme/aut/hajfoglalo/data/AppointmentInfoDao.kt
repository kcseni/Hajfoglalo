package hu.bme.aut.hajfoglalo.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AppointmentInfoDao {
    @Query("SELECT * FROM appointment")
    fun getAll(): LiveData<List<AppointmentInfo>>

    @Query("SELECT name FROM appointment WHERE id LIKE :ide")
    fun getNames(ide: Int): String

    @Insert
    suspend fun insert(appointmentInfo: AppointmentInfo)

    @Update
    suspend fun update(appointmentInfo: AppointmentInfo)

    @Delete
    suspend fun deleteItem(appointmentInfo: AppointmentInfo)

    @Query("DELETE FROM appointment")
    suspend fun deleteAll()

}