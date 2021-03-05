package com.example.autorizationapponmvp.presenters

import com.example.autorizationapponmvp.constants.RegisterConstants
import com.example.autorizationapponmvp.interfaces.RegisterPresenterInterface
import com.example.autorizationapponmvp.models.UserModel
import com.example.autorizationapponmvp.views.RegisterViewInterface

class RegisterPresenter(private var registerViewInterface: RegisterViewInterface) :
    RegisterPresenterInterface {

    override fun onDataValid(email: String, password: String, repeatedPassword: String) {
        val user = UserModel(email, password)
        val registerCode = user.isDataValid()

        when (registerCode) {
            RegisterConstants.EMPTY_EMAIL_ERROR_CODE ->
                registerViewInterface
                    .onRegisterError(RegisterConstants.EMPTY_EMAIL_ERROR_MESSAGE)
            RegisterConstants.INCORRECT_EMAIL_ERROR_CODE ->
                registerViewInterface
                    .onRegisterError(RegisterConstants.INCORRECT_EMAIL_ERROR_MESSAGE)
            RegisterConstants.SHORT_PASSWORD_LENGTH_ERROR_CODE ->
                registerViewInterface
                    .onRegisterError(RegisterConstants.SHORT_PASSWORD_LENGTH_ERROR_MESSAGE)
            RegisterConstants.DATA_VALID_SUCCESS_CODE -> {
                if (password == repeatedPassword)
                    registerViewInterface
                        .onRegisterSuccess(RegisterConstants.REGISTER_SUCCESS_MESSAGE)
                else
                    registerViewInterface
                        .onRegisterError(RegisterConstants.DIFFERENT_PASSWORDS_ERROR_MESSAGE)
            }
        }
    }
}