package com.example.taskappplaner.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class user(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    val eame: String,
    val email: String
) {

    constructor(name: String, email: String) : this(0, name, email)
}