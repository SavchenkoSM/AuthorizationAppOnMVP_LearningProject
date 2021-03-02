package com.example.autorizationapponmvp.presenter

interface LoginPresenterInterface {
    fun onDataValid(email:String, password: String)
    fun onLogin(email:String, password: String)
}