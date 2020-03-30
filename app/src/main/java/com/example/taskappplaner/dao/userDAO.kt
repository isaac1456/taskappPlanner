package com.example.taskappplaner.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.taskappplaner.model.user

@Dao
interface userDAO {

    @Insert
    suspend fun Insert(user: user)

    @Query("SELECT * FROM user")
    fun getAlluser(): LiveData<List<user>>

}