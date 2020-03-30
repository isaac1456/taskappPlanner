package com.example.taskappplaner.dao


import com.example.taskappplaner.model.tokenDTO
import com.example.taskappplaner.model.userDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface getTokenService {

    @POST("auth")
    suspend fun getToken(@Body userDto: userDTO): Response<tokenDTO>

}