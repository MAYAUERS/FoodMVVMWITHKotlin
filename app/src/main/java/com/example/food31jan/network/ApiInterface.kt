package com.example.food31jan.network

import com.example.food31jan.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
//https://gorest.co.in/public/v1/users
    @GET("public/v1/users")
    suspend fun getUsers() : Response<Users>
}