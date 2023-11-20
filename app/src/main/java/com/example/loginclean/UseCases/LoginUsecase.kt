package com.example.loginclean.UseCases

import com.example.loginclean.DomainLayer.Modal.LoginResponse
import com.example.loginclean.DomainLayer.Modal.RequestLogin
import com.example.loginclean.DomainLayer.Repos.Repositories
import retrofit2.Response

class LoginUsecase() {
    val loginRepository= Repositories()


    suspend fun login(email: String, password: String):Response<LoginResponse>{

        val loginRequest = RequestLogin(email, password)


        return loginRepository.performLoginAndPostToApi(loginRequest)



    }


}