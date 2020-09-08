package com.example.controle

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    var userId: Long = 0L,
    @ColumnInfo(name = "age")
    var age: String,
    @ColumnInfo(name = "weight")
    var weight: String,
    @ColumnInfo(name = "name")
    var name: String
) {

    @Ignore
    var userPic : String = "https://images-na.ssl-images-amazon.com/images/I/61vhfnst%2BML._AC_SX466_.jpg"
}