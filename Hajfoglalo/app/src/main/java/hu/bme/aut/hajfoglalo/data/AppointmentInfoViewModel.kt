package hu.bme.aut.hajfoglalo.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppointmentInfoViewModel(application: Application): AndroidViewModel(application) {

    val getAllData: LiveData<List<AppointmentInfo>>
    private val repository: AppointmentRepository

    init{
        val appointmentInfoDao = AppointmentInfoDatabase.getDatabase(application).appointmentInfoDao()
        repository = AppointmentRepository(appointmentInfoDao)
        getAllData=repository.getalldata


    }

    fun addAppointment(item:AppointmentInfo){
        viewModelScope.launch(Dispatchers.IO){
            repository.addAppointment(item)
        }
    }

    fun deleteAppointment(item:AppointmentInfo){
        viewModelScope.launch (Dispatchers.IO ){
            repository.deleteAppointment(item)
        }

    }

    fun deleteAllAppointment(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }


}