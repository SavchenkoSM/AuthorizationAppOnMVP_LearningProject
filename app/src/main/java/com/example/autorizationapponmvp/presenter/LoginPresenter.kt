package com.example.autorizationapponmvp.presenter

import com.example.autorizationapponmvp.common.Constants
import com.example.autorizationapponmvp.model.UserClass
import com.example.autorizationapponmvp.view.LoginViewInterface

class LoginPresenter(private var loginViewInterface: LoginViewInterface) :
    LoginPresenterInterface {

    override fun onDataValid(email: String, password: String) {
        val user = UserClass(email, password)
        val loginCode = user.isDataValid()

        when (loginCode) {
            Constants.EMPTY_EMAIL_ERROR_CODE ->
                loginViewInterface.onDataValidError("Email must not be null")
            Constants.WRONG_EMAIL_PATTERNS_ERROR_CODE ->
                loginViewInterface.onDataValidError("Incorrect email address")
            Constants.PASSWORD_LENGTH_ERROR_CODE ->
                loginViewInterface.onDataValidError("Password must contain no less 8 characters")
            Constants.EMPTY_PASSWORD_ERROR_CODE ->
                loginViewInterface.onDataValidError("Password must not be null")
            Constants.DATA_SUCCESS_CODE ->
                loginViewInterface.onDataValidSuccess("Data entered correctly")
        }
    }

    override fun onLogin(email: String, password: String) {
        val user = UserClass(email, password)
        val loginCode = user.isUserExist()

        if (loginCode == Constants.LOGIN_SUCCESS_CODE)
            loginViewInterface.onLoginSuccess("Login successfully")
        else
            loginViewInterface.onLoginError("User is not exist")
    }
}