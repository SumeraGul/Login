package com.example.loginclean.DomainLayer.Modal

import retrofit2.Response

data class RequestLogin(
    var userName: String =  "",
    var password: String = "",
    val key: String = "08c53114-cbe9-42f9-aa4d-18024e44e90c"

)
