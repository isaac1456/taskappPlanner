package com.example.taskappplaner.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.taskappplaner.model.modelTask

@Dao
interface taskDao {

    @Insert
    suspend fun create(modelTask: modelTask)

    @Query("select * from modelTask")
    fun getAllTask(): LiveData<List<modelTask>>


}