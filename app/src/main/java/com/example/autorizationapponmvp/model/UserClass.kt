package com.example.autorizationapponmvp.model

import android.text.TextUtils
import android.util.Patterns
import com.example.autorizationapponmvp.common.Constants

class UserClass(override val email: String, override val password: String) : UserInterface {

    override fun isDataValid(): Int {
        return when {
            TextUtils.isEmpty(email) ->
                Constants.EMPTY_EMAIL_ERROR_CODE
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() ->
                Constants.WRONG_EMAIL_PATTERNS_ERROR_CODE
            password.length < 8 ->
                Constants.PASSWORD_LENGTH_ERROR_CODE
            TextUtils.isEmpty(password) ->
                Constants.EMPTY_PASSWORD_ERROR_CODE
            else ->
                Constants.DATA_SUCCESS_CODE
        }
    }

    override fun isUserExist(): Int {
        return if (email == Constants.USER_EMAIL && password == Constants.USER_PASSWORD)
            Constants.LOGIN_SUCCESS_CODE
        else
            Constants.USER_IS_NOT_EXIST_ERROR_CODE
    }
}