package hu.bme.aut.hajfoglalo.data

import androidx.lifecycle.LiveData

class ServiceRepository(private val serviceItemDao : ServiceItemDao) {

    val getalldata : LiveData<List<ServiceItem>> = serviceItemDao.getAll()
    suspend fun addService(item: ServiceItem){
        serviceItemDao.insert(item)
    }

    suspend fun deleteService(item:ServiceItem){
        serviceItemDao.deleteItem(item)
    }

    suspend fun deleteAll(){
        serviceItemDao.deleteAll()
    }

    suspend fun deletebyName(nev : String){
        serviceItemDao.deleteItembyName(nev)
    }

}