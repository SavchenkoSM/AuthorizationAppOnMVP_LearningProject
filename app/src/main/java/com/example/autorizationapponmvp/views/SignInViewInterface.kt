package com.example.autorizationapponmvp.views

interface SignInViewInterface {
    fun onSignInSuccess(message: String)
    fun onSignInError(message: String)
}