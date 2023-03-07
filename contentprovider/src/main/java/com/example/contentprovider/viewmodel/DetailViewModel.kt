package com.example.contentprovider.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.contentprovider.data.local.FavoriteUser
import com.example.contentprovider.data.remote.responses.detail.DetailResponse
import com.example.contentprovider.data.remote.responses.follower.FollowersResponses
import com.example.contentprovider.data.remote.responses.following.FollowingResponses
import com.example.contentprovider.repository.SearchGithubRepo
import com.example.contentprovider.repository.UserFavoriteRepository
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val api: SearchGithubRepo,
    private val favRepo: UserFavoriteRepository
) : ViewModel() {

    private val _dataDetail = MutableLiveData<DetailResponse>()
    val dataDetail: LiveData<DetailResponse> = _dataDetail
    private val _dataFollowers = MutableLiveData<FollowersResponses>()
    val dataFollowers: LiveData<FollowersResponses> = _dataFollowers
    private val _dataFollowing = MutableLiveData<FollowingResponses>()
    val dataFollowing: LiveData<FollowingResponses> = _dataFollowing

    fun getDataDetail(username: String) = viewModelScope.launch {
        api.getDetailUser(username).also {
            if (it.isSuccessful) {
                _dataDetail.value = it.body()
            } else {
                Log.d("DetailViewModel", "getDataDetail: ${it.message()} ${it.code()} ")
            }
        }
    }

    fun getFollowers(userName: String) = viewModelScope.launch {
        api.getFollower(userName).also {
            if (it.isSuccessful) {
                _dataFollowers.value = it.body()
            } else
                Log.d("DetailViewModel", "getDataFollowers: ${it.message()} ${it.code()} ")
        }
    }


    fun getFollowing(userName: String) = viewModelScope.launch {
        api.getFollowing(userName).also {
            if (it.isSuccessful) {
                _dataFollowing.value = it.body()
            } else
                Log.d("DetailViewModel", "getDataFollowing: ${it.message()} ${it.code()} ")
        }
    }

    fun insertToFavorite(userName: String,id: Int,avatarUrl : String) = viewModelScope.launch {
        val user = FavoriteUser(id,userName,avatarUrl)
        favRepo.insertUserToFavorite(user)
    }

    fun deleteFromFavorite(id: Int) = viewModelScope.launch {
        favRepo.deleteUserFavorite(id)
    }

     suspend fun checkUserFavorite(id: Int) = favRepo.checkUserFavorite(id)

}