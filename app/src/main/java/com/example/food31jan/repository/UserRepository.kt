package com.example.food31jan.repository

import com.example.food31jan.model.Users
import com.example.food31jan.network.ApiClient
import com.example.food31jan.network.ApiInterface
import retrofit2.Response

class UserRepository {

    lateinit var apiInterface: ApiInterface

    public suspend fun getApiUserData():Response<Users>{
        apiInterface=ApiClient.getApiClient().create(ApiInterface::class.java)
        return apiInterface.getUsers()
    }
}