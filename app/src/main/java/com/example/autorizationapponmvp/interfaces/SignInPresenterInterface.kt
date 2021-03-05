package com.example.autorizationapponmvp.interfaces

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface SignInPresenterInterface {
    fun onSignIn(email:String, password: String)
}