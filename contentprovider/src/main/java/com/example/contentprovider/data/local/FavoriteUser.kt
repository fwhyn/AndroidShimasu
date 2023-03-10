package com.example.contentprovider.data.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "favorite_table")
data class FavoriteUser(
    @PrimaryKey
    val id: Int,
    val username: String,
    @ColumnInfo(name = "avatar_url") val avatarUrl: String,
) : Parcelable