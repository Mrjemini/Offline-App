package com.example.offlineapp.repository

import android.content.Context
import com.example.offlineapp.data.local.User
import com.example.offlineapp.data.local.UserDatabase
import com.example.offlineapp.data.remote.RetrofitInstance
import com.example.offlineapp.utils.NetworkUtils

class UserRepository(context: Context) {
    private val userDao = UserDatabase.getInstance(context).userDao()
    private val apiService = RetrofitInstance.api
    private val appContext = context.applicationContext

    suspend fun getUsers(): List<User> {
        return if (NetworkUtils.isConnected(appContext)) {
            val response = apiService.getUsers()
            if (response.isSuccessful) {
                response.body()?.users?.also { userDao.insertAll(it) } ?: emptyList()
            } else {
                userDao.getAllUsers()
            }
        } else {
            userDao.getAllUsers()
        }
    }
}