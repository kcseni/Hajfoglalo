package hu.bme.aut.hajfoglalo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "price")
data class Price (
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "price") var price: String)
{}