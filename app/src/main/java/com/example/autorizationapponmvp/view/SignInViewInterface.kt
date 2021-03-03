package com.example.autorizationapponmvp.view

interface SignInViewInterface {
    fun onSignInSuccess(message: String)
    fun onSignInError(message: String)
}