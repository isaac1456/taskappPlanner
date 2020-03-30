package com.example.taskappplaner.dependencies

const val tokenKey = "tokenKey"

interface storagePrefer {
    fun saveToken(token: String)

    fun getToken(): String

    fun clear()
}