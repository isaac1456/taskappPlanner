package com.example.taskappplaner.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class modelTask(
    @PrimaryKey(autoGenerate = true) var id: Long, val name: String,
    val Description: String
) {
    constructor(id: String, name: String, Description: String) : this(0, name, Description)
}