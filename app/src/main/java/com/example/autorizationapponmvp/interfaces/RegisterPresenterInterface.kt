package com.example.autorizationapponmvp.interfaces

interface RegisterPresenterInterface {
    fun onDataValid(email: String, password: String, repeatedPassword: String)
}