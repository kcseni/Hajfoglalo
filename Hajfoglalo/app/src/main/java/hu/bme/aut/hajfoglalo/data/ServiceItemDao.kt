package hu.bme.aut.hajfoglalo.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ServiceItemDao {
    @Query("SELECT * FROM serviceitem")
    fun getAll(): LiveData<List<ServiceItem>>

    @Query("DELETE  FROM serviceitem WHERE name LIKE :nev")
    fun deleteItembyName(nev: String)

    @Insert
    suspend fun insert(serviceItems: ServiceItem)

    @Update
    suspend fun update(serviceItem: ServiceItem)

    @Delete
    suspend fun deleteItem(serviceItem: ServiceItem)

    @Query("DELETE FROM serviceitem")
    suspend fun deleteAll()

}
