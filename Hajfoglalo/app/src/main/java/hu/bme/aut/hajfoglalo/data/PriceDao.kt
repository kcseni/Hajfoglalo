package hu.bme.aut.hajfoglalo.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PriceDao {
    @Query("SELECT * FROM price")
    fun getAll(): LiveData<List<Price>>

    @Insert
    suspend fun insert(price: Price)

    @Update
    suspend fun update(price: Price)

    @Delete
    suspend fun deleteItem(price: Price)

    @Query("DELETE FROM price")
    suspend fun deleteAll()

}