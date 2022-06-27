package hu.bme.aut.hajfoglalo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appointment")
data class AppointmentInfo (
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var id: Int ,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "phonenum") var phonenumber: String,
    @ColumnInfo(name = "datetime") var datetime: String,
)



{}
