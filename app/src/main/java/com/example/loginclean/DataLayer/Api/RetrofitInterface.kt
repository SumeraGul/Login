package com.example.loginclean.DataLayer.Api

import com.example.loginclean.DomainLayer.Modal.LoginResponse
import com.example.loginclean.DomainLayer.Modal.RequestLogin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitInterface {
    @POST("simpleSurveyAuthV1_1")
    suspend fun  PostLoginData(@Body requestBody: RequestLogin):Response<LoginResponse>


}