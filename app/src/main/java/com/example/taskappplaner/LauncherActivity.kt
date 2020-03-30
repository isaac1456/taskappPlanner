package com.example.taskappplaner

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log

class LauncherActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
        Log.i("LauncherActivity", "onCreate: Entro")
    }
}