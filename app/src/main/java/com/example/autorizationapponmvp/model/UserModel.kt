package com.example.autorizationapponmvp.model

import android.text.TextUtils
import android.util.Patterns
import com.example.autorizationapponmvp.common.RegisterConstants
import com.example.autorizationapponmvp.common.SignInConstants

class UserModel(override val email: String, override val password: String) : UserModelInterface {

    override fun isDataValid(): Int {
        return when {
            TextUtils.isEmpty(email) ->
                RegisterConstants.EMPTY_EMAIL_ERROR_CODE
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() ->
                RegisterConstants.INCORRECT_EMAIL_ERROR_CODE
            password.length < RegisterConstants.MIN_PASSWORD_LENGTH ->
                RegisterConstants.SHORT_PASSWORD_LENGTH_ERROR_CODE
            else ->
                RegisterConstants.REGISTER_SUCCESS_CODE
        }
    }

    override fun isUserExist(): Int {
        return if (email == SignInConstants.USER_EMAIL && password == SignInConstants.USER_PASSWORD)
            SignInConstants.LOGIN_SUCCESS_CODE
        else
            SignInConstants.USER_IS_NOT_EXIST_LOGIN_ERROR_CODE
    }
}