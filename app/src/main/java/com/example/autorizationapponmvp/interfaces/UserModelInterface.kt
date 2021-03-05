package com.example.autorizationapponmvp.interfaces

interface UserModelInterface {
    val email: String
    val password: String

    fun isDataValid(): Int
    fun isUserExist(): Int
}