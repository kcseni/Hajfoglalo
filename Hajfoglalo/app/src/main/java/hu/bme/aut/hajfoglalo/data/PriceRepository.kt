package hu.bme.aut.hajfoglalo.data

import androidx.lifecycle.LiveData

class PriceRepository(private val priceDao: PriceDao) {

    val getalldata : LiveData<List<Price>> = priceDao.getAll()
    suspend fun addPrice(price: Price){
        priceDao.insert(price)
    }

    suspend fun deletePrice(price: Price){
        priceDao.deleteItem(price)
    }

    suspend fun deleteAll(){
        priceDao.deleteAll()
    }



}