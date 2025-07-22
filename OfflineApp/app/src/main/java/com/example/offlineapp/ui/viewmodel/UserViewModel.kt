package com.example.offlineapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.offlineapp.data.local.User
import com.example.offlineapp.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = UserRepository(application)

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    fun fetchUsers() {
        viewModelScope.launch {
            _users.value = repository.getUsers()
        }
    }
}
