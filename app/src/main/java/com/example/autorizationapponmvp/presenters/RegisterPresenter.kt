package com.example.autorizationapponmvp.presenters

import com.example.autorizationapponmvp.common.RegisterConstants
import com.example.autorizationapponmvp.interfaces.RegisterPresenterInterface
import com.example.autorizationapponmvp.models.UserModel
import com.example.autorizationapponmvp.views.RegisterViewInterface

class RegisterPresenter(private var registerViewInterface: RegisterViewInterface) :
    RegisterPresenterInterface {

    override fun onDataValid(email: String, password: String) {
        val user = UserModel(email, password)
        val registerCode = user.isDataValid()

        when (registerCode) {
            RegisterConstants.EMPTY_EMAIL_ERROR_CODE ->
                registerViewInterface.onDataValidError(RegisterConstants.EMPTY_EMAIL_MESSAGE)
            RegisterConstants.INCORRECT_EMAIL_ERROR_CODE ->
                registerViewInterface.onDataValidError(RegisterConstants.INCORRECT_EMAIL_MESSAGE)
            RegisterConstants.SHORT_PASSWORD_LENGTH_ERROR_CODE ->
                registerViewInterface.onDataValidError(RegisterConstants.SHORT_PASSWORD_LENGTH_MESSAGE)
            RegisterConstants.REGISTER_SUCCESS_CODE ->
                registerViewInterface.onDataValidSuccess(RegisterConstants.REGISTER_SUCCESS_MESSAGE)
        }
    }
}