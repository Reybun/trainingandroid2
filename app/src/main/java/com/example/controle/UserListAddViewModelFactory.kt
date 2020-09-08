package com.example.controle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserListAddViewModelFactory(private val userDao: UserDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserListAddViewModel::class.java)) {
            return UserListAddViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}