package com.example.autorizationapponmvp.common

/**
 * Объект, содержащий константы, используемые в проекте
 */
object SignInConstants {
    // Код ошибки при авторизации
    const val USER_IS_NOT_EXIST_LOGIN_ERROR_CODE = 3

    // Код успешной авторизации
    const val LOGIN_SUCCESS_CODE = -1

    // Комбинация email и password для входа
    // (используются при проверки существует ли пользователь)
    const val USER_EMAIL = "admin@mail.ru"
    const val USER_PASSWORD = "admin1234"

    // Сообщения для пользователя
    const val SIGN_IN_SUCCESS_MESSAGE = "Sign in successfully"
    const val SIGN_IN_ERROR_MESSAGE = "Sign in error. Such user is not exist"
}