package com.example.autorizationapponmvp.interfaces

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface RegisterPresenterInterface {
    fun onDataValid(email: String, password: String, repeatedPassword: String)
}