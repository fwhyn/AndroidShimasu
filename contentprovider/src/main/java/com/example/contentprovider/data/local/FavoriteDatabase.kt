package com.example.contentprovider.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [FavoriteUser::class], version = 1, exportSchema = false)
abstract class FavoriteDatabase : RoomDatabase() {
    abstract fun getUserFavoriteDao(): FavoriteUserDao
}