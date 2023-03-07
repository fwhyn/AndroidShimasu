package com.example.consumerapp

import androidx.lifecycle.liveData
import com.example.consumerapp.UserDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class UserFavoriteRepository constructor(private val data: UserDataSource) {

    val allFavoriteUser = liveData {
        withContext(Dispatchers.IO) {
            emit(data.getUsers())
        }

    }
}