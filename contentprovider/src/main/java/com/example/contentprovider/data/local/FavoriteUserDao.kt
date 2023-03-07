package com.example.contentprovider.data.local

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.contentprovider.data.local.FavoriteUser
import kotlinx.coroutines.flow.Flow


@Dao
interface FavoriteUserDao {
    @Query("SELECT * FROM favorite_table")
    fun getAllFavoriteUser(): Flow<List<FavoriteUser>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserToFavorite(user: FavoriteUser)

    @Query("DELETE FROM favorite_table WHERE id= :id")
    suspend fun deleteUserFromFavorite(id: Int) : Int

    @Query("SELECT count(*) FROM favorite_table WHERE id = :id")
    fun checkUserFavs(id: Int): Int

    @Query("SELECT * FROM favorite_table")
    fun findAll(): Cursor

}