package com.example.controle

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class UserDetailViewModel(private val userDataDao: UserDao, private val userId: String) : ViewModel() {

    val userChosenObs : LiveData<User> = userDataDao.getUser(userId.toLong())



}