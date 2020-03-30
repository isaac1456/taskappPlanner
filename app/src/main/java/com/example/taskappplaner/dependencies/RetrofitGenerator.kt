package com.example.taskappplaner.dependencies

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitGenerator {

    companion object {
        @Volatile
        private var instance: Retrofit? = null

        fun getInstance(): Retrofit {
            return instance ?: synchronized(this) {
                instance
                    ?: buildRetrofit().also { instance = it }
            }
        }

        private fun buildRetrofit(): Retrofit {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .writeTimeout(0, TimeUnit.MILLISECONDS)
                .readTimeout(2, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES).build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://tasks-planner-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}