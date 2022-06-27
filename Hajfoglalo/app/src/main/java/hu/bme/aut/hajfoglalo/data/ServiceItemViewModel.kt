package hu.bme.aut.hajfoglalo.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ServiceItemViewModel(application: Application): AndroidViewModel(application) {

     val getAllData: LiveData<List<ServiceItem>>
    private val repository: ServiceRepository

    init{
        val serviceItemDao = ServiceItemDatabase.getDatabase(application).serviceItemDao()
        repository = ServiceRepository(serviceItemDao)
        getAllData=repository.getalldata


    }

    fun addServiceItem(item:ServiceItem){
        viewModelScope.launch(Dispatchers.IO){
            repository.addService(item)
        }
    }

    fun deleteServiceItem(item:ServiceItem){
        viewModelScope.launch (Dispatchers.IO ){
            repository.deleteService(item)
        }

    }

    fun deleteAllServiceItem(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }

    fun deletebyName(nev: String){
        viewModelScope.launch (Dispatchers.IO ){
            repository.deletebyName(nev)
        }

    }


}