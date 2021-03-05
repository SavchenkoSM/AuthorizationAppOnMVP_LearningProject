package com.example.autorizationapponmvp.presenters

import com.example.autorizationapponmvp.constants.RegisterConstants
import com.example.autorizationapponmvp.interfaces.RegisterPresenterInterface
import com.example.autorizationapponmvp.models.UserModel
import com.example.autorizationapponmvp.views.RegisterViewInterface
import moxy.InjectViewState
import moxy.MvpPresenter

// @InjectViewState – аннотация для привязывания ViewState к Presenter
@InjectViewState
class RegisterPresenter : MvpPresenter<RegisterViewInterface>(),
    RegisterPresenterInterface {

    override fun onDataValid(email: String, password: String, repeatedPassword: String) {
        val user = UserModel(email, password)
        val registerCode = user.isDataValid()

        when (registerCode) {
            RegisterConstants.EMPTY_EMAIL_ERROR_CODE ->
                viewState
                    .onRegisterError(RegisterConstants.EMPTY_EMAIL_ERROR_MESSAGE)
            RegisterConstants.INCORRECT_EMAIL_ERROR_CODE ->
                viewState
                    .onRegisterError(RegisterConstants.INCORRECT_EMAIL_ERROR_MESSAGE)
            RegisterConstants.SHORT_PASSWORD_LENGTH_ERROR_CODE ->
                viewState
                    .onRegisterError(RegisterConstants.SHORT_PASSWORD_LENGTH_ERROR_MESSAGE)
            RegisterConstants.DATA_VALID_SUCCESS_CODE -> {
                if (password == repeatedPassword)
                    viewState
                        .onRegisterSuccess(RegisterConstants.REGISTER_SUCCESS_MESSAGE)
                else
                    viewState
                        .onRegisterError(RegisterConstants.DIFFERENT_PASSWORDS_ERROR_MESSAGE)
            }
        }
    }
}