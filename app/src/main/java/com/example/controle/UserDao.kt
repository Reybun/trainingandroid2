package com.example.controle

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM user WHERE user.userId = :userId")
    fun getUser(userId: Long) : LiveData<User>

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun deleteOne(user: User)

    @Query("SELECT * FROM user")
    fun getAllUser(): LiveData<List<User>>
}