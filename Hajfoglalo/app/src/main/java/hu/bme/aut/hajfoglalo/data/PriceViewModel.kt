package hu.bme.aut.hajfoglalo.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PriceViewModel(application: Application): AndroidViewModel(application) {

    val getAllData: LiveData<List<Price>>
    private val repository: PriceRepository

    init{
        val priceDao = PriceDatabase.getDatabase(application).priceDao()
        repository = PriceRepository(priceDao)
        getAllData=repository.getalldata


    }

    fun addPrice(price: Price){
        viewModelScope.launch(Dispatchers.IO){
            repository.addPrice(price)
        }
    }

    fun deletePrice(price: Price){
        viewModelScope.launch (Dispatchers.IO ){
            repository.deletePrice(price)
        }

    }

    fun deleteAllPrice(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }


}