package com.example.autorizationapponmvp.views

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface SignInViewInterface : MvpView {
    // @AddToEndSingleStrategy — аннотация, используемая когда команда должна применяться
    // при пересоздании view не более одного раза
    @AddToEndSingle
    fun onSignInSuccess(message: String)

    // @SkipStrategy - аннотация, используемая когда необходимо выполнить некоторое действие
    // прямо сейчас и только в случае, если имеется View в активном состоянии
    @Skip
    fun onSignInError(message: String)
}