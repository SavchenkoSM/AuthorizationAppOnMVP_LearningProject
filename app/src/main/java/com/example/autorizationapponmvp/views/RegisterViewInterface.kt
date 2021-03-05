package com.example.autorizationapponmvp.views

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface RegisterViewInterface: MvpView {
    @AddToEndSingle
    fun onRegisterSuccess(message: String)

    @Skip
    fun onRegisterError(message: String)
}