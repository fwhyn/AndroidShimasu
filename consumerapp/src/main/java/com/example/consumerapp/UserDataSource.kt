package com.example.consumerapp

import android.content.ContentResolver
import com.example.consumerapp.DatabaseContract.FavoriteUserColumn.Companion.MY_CONTENT_URI


class UserDataSource(private val contentResolver: ContentResolver) {
    fun getUsers(): List<FavoriteUser> {
        val result: MutableList<FavoriteUser> = mutableListOf()

        val cursor = contentResolver.query(
            MY_CONTENT_URI,
            null,
            null,
            null,
            null
        )

        cursor?.apply {
            while (moveToNext()) {
                result.add(
                    FavoriteUser(
                        getInt(getColumnIndexOrThrow(DatabaseContract.FavoriteUserColumn.ID)),
                        getString(getColumnIndexOrThrow(DatabaseContract.FavoriteUserColumn.USERNAME)),
                        getString(getColumnIndexOrThrow(DatabaseContract.FavoriteUserColumn.AVATAR_URL)),
                    )
                )
            }
            close()
        }
        return result.toList()
    }
}