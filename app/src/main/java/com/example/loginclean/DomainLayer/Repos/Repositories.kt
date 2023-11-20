package com.example.loginclean.DomainLayer.Repos

import com.example.loginclean.DataLayer.Api.RetrofitClient
import com.example.loginclean.DomainLayer.Modal.LoginResponse
import com.example.loginclean.DomainLayer.Modal.RequestLogin
import com.example.loginclean.UseCases.LoginUsecase
import retrofit2.Response

class Repositories () {

    val apiService = RetrofitClient.retrofitService

    suspend fun performLoginAndPostToApi(loginRequest: RequestLogin): Response<LoginResponse> {
        return try {
            apiService.PostLoginData(loginRequest)
        } catch (e: Exception) {

            throw e
        }
    }
}