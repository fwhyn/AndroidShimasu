package com.example.contentprovider.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.contentprovider.data.remote.responses.search.SearchUserResponse
import com.example.contentprovider.repository.SearchGithubRepo
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: SearchGithubRepo
) : ViewModel() {

    private val _dataSearchUser = MutableLiveData<SearchUserResponse>()
    val dataSearchUser: LiveData<SearchUserResponse> = _dataSearchUser

    fun getSearchUser(query: String) = viewModelScope.launch {
        repo.getSearchUser(query).run {
            if (this.isSuccessful) {
                _dataSearchUser.value = this.body()
            }
        }

    }
}
