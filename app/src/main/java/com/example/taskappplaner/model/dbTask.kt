package com.example.taskappplaner.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taskappplaner.dao.taskDao
import com.example.taskappplaner.dao.userDAO

@Database(entities = [user::class, modelTask::class], version = 1)
abstract class dbTask : RoomDatabase() {

    abstract fun userDao(): userDAO
    abstract fun taskDao(): taskDao

    companion object {

        @Volatile
        private var instance: dbTask? = null

        fun getInstance(context: Context): dbTask {
            return instance ?: synchronized(this) {
                instance
                    ?: buildDatabase(
                        context
                    ).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): dbTask {
            return Room.databaseBuilder(context, dbTask::class.java, "dbTask")
                .build()
        }
    }
}