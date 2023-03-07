package com.example.contentprovider.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.contentprovider.data.local.FavoriteUser
import com.example.contentprovider.repository.UserFavoriteRepository
import javax.inject.Inject


@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val favRepo: UserFavoriteRepository
) : ViewModel() {

    val allFavoriteUser: LiveData<List<FavoriteUser>> = favRepo.allFavoriteUser.asLiveData()
}