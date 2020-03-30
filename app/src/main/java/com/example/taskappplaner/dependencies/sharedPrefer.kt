package com.example.taskappplaner.dependencies

import android.content.Context

class sharedPrefer(con: Context) : storagePrefer {
    private val sharedPreferences = con.getSharedPreferences("sharedPrefer", Context.MODE_PRIVATE)

    override fun saveToken(token: String) {
        sharedPreferences.edit().putString(tokenKey, token).apply()
    }

    override fun getToken(): String {
        return sharedPreferences.getString(tokenKey, "")!!
    }

    override fun clear() {
        sharedPreferences.edit().remove(tokenKey).apply()

    }
}