package com.example.controle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserDetailViewModelFactory(private val userDao: UserDao, private val userId : String) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserDetailViewModel::class.java)) {
            return UserDetailViewModel(userDao,userId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}