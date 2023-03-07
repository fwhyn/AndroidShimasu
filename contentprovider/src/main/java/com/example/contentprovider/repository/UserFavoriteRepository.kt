package com.example.contentprovider.repository

import com.example.contentprovider.data.local.FavoriteUser
import com.example.contentprovider.data.local.FavoriteUserDao
import javax.inject.Inject

/**
 * Created By Taufiq on 3/17/2021.
 *
 */
class UserFavoriteRepository @Inject constructor(private val dao: FavoriteUserDao) {

    val allFavoriteUser = dao.getAllFavoriteUser()

    suspend fun insertUserToFavorite(user: FavoriteUser) =
        dao.insertUserToFavorite(user)

    suspend fun deleteUserFavorite(id: Int) =
        dao.deleteUserFromFavorite(id)

     suspend fun checkUserFavorite(id: Int) =
        dao.checkUserFavs(id)
}