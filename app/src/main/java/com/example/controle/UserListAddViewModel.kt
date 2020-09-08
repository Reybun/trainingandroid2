package com.example.controle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserListAddViewModel(private val userDataDao: UserDao) : ViewModel(), IUserAdapterCallBack {

    var usersObs: LiveData<List<User>> = userDataDao.getAllUser()
    var userIdSelectedObs = MutableLiveData<String>()
    private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')


    override fun onUserSelect(userId: Long) {
        userIdSelectedObs.value = userId.toString()
    }

    fun newRandomUser() {
        val randomString = (1..5)
            .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("");
        val newUser = User(name = randomString, age = (1..50).random().toString(), weight = (19..80).random().toString() )
        viewModelScope.launch {
            userDataDao.insert(newUser)
        }
    }

}