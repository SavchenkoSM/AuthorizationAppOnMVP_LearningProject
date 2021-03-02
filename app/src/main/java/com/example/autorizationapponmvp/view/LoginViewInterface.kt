package com.example.autorizationapponmvp.view

interface LoginViewInterface {
    fun onDataValidSuccess(message: String)
    fun onDataValidError(message: String)

    fun onLoginSuccess(message: String)
    fun onLoginError(message: String)
}