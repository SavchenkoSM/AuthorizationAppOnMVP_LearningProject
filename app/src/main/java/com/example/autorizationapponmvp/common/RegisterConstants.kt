package com.example.autorizationapponmvp.common

object RegisterConstants {
    // Коды ошибок при заполении полей
    const val EMPTY_EMAIL_ERROR_CODE = 0
    const val INCORRECT_EMAIL_ERROR_CODE = 1
    const val SHORT_PASSWORD_LENGTH_ERROR_CODE = 2

    // Код успешной регистрации
    const val REGISTER_SUCCESS_CODE = -2

    // Константы, ограничивающие значениея для полей
    const val MIN_PASSWORD_LENGTH = 8

    // Сообщения для пользователя
    const val EMPTY_EMAIL_MESSAGE = "Email must not be null"
    const val INCORRECT_EMAIL_MESSAGE = "Incorrect email address"
    const val SHORT_PASSWORD_LENGTH_MESSAGE =
        "Password must contain no less than $MIN_PASSWORD_LENGTH characters"
    const val REGISTER_SUCCESS_MESSAGE = "Registration successfully"
}