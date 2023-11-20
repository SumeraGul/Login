package com.example.loginclean.DataLayer.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient  {
    private const val BASE_URL = "http://54.179.225.22:6050/api/v1/"
    private const val S3_URL = ""

    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            //.client(OKHttpclient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val S3instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(S3_URL)
            //.client(OKHttpclient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
   val retrofitService :RetrofitInterface by lazy {
       instance.create(RetrofitInterface::class.java)
   }
    val retrofitServiceS3 :RetrofitInterface by lazy {
        S3instance.create(RetrofitInterface::class.java)
    }



}