package com.example.autorizationapponmvp.presenters

import com.example.autorizationapponmvp.constants.SignInConstants
import com.example.autorizationapponmvp.interfaces.SignInPresenterInterface
import com.example.autorizationapponmvp.models.UserModel
import com.example.autorizationapponmvp.views.SignInViewInterface
import moxy.InjectViewState
import moxy.MvpPresenter

// @InjectViewState – аннотация для привязывания ViewState к Presenter
@InjectViewState
class SignInPresenter : MvpPresenter<SignInViewInterface>(),
    SignInPresenterInterface {

    override fun onSignIn(email: String, password: String) {
        val user = UserModel(email, password)
        val signInCode = user.isUserExist()

        if (signInCode == SignInConstants.SIGN_IN_SUCCESS_CODE)
            viewState.onSignInSuccess(SignInConstants.SIGN_IN_SUCCESS_MESSAGE)
        else
            viewState.onSignInError(SignInConstants.SIGN_IN_ERROR_MESSAGE)
    }
}