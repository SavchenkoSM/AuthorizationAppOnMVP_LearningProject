package com.example.autorizationapponmvp.constants

/**
 * Объект, содержащий константы, используемые для реализации Авторизации
 */
object SignInConstants {
    // Код ошибки при авторизации
    const val USER_IS_NOT_EXIST_SIGN_IN_ERROR_CODE = 3

    // Код успешной авторизации
    const val SIGN_IN_SUCCESS_CODE = -1

    // Комбинация email и password для входа
    // (используется при проверке зарегистрирован пользователь или нет)
    const val USER_EMAIL = "admin@mail.ru"
    const val USER_PASSWORD = "admin1234"

    // Сообщения для пользователя
    const val SIGN_IN_SUCCESS_MESSAGE = "Sign in successfully"
    const val SIGN_IN_ERROR_MESSAGE = "Sign in error. Such user is not exist"
}