package hu.bme.aut.hajfoglalo.data

import androidx.lifecycle.LiveData

class AppointmentRepository(private val appointmentInfoDao: AppointmentInfoDao) {

    val getalldata : LiveData<List<AppointmentInfo>> = appointmentInfoDao.getAll()
    suspend fun addAppointment(item: AppointmentInfo){
        appointmentInfoDao.insert(item)
    }

    suspend fun deleteAppointment(item:AppointmentInfo){
        appointmentInfoDao.deleteItem(item)
    }

    suspend fun deleteAll(){
        appointmentInfoDao.deleteAll()
    }

}