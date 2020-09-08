package com.example.controle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserListDetailViewModel(private val userDataDao: UserDao) : ViewModel(), IUserAdapterCallBack {

    var usersObs: LiveData<List<User>>
    var userIdSelectedObs = MutableLiveData<String>()

    init {
        creation()
        usersObs = userDataDao.getAllUser()
    }

    fun creation() {
        viewModelScope.launch {
            userDataDao.insert(User(name = "Yann", age = "54", weight = "74"))
            userDataDao.insert(User(name = "Farine", age = "4", weight = "2"))
        }
    }

    fun updateUser() {
        viewModelScope.launch {
            userDataDao.insert(User(name = "NewUser", age = "584", weight = "574"))
        }
    }

    override fun onUserSelect(userId: Long) {
        userIdSelectedObs.value = userId.toString()
    }

}