package com.example.food31jan.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object{
        var BASEURL:String="https://gorest.co.in/"
        val httpLoggingInterceptor=HttpLoggingInterceptor()
        val okHttpClient=OkHttpClient()

        fun getApiClient():Retrofit{
            return Retrofit.Builder().baseUrl(BASEURL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }
}