package com.example.controle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserListDetailViewModelFactory(private val userDao: UserDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserListDetailViewModel::class.java)) {
            return UserListDetailViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}