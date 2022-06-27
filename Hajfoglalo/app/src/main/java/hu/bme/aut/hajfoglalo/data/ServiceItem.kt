package hu.bme.aut.hajfoglalo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.reflect.Constructor

@Entity(tableName = "serviceitem")
data class ServiceItem(

    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var id: Int ,
    @ColumnInfo(name = "name") var name: String





) {

        }


