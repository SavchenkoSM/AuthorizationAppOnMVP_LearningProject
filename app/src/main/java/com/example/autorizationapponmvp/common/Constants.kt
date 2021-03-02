package com.example.autorizationapponmvp.common

/**
 * Объект, содержащий константы, используемые в проекте
 */
object Constants {
    // Коды, используемые для проверки корректности данных, введенных при входе
    const val EMPTY_EMAIL_ERROR_CODE = 0
    const val WRONG_EMAIL_PATTERNS_ERROR_CODE = 1
    const val PASSWORD_LENGTH_ERROR_CODE = 2
    const val EMPTY_PASSWORD_ERROR_CODE = 3
    const val USER_IS_NOT_EXIST_ERROR_CODE = 4

    const val DATA_SUCCESS_CODE = -2
    const val LOGIN_SUCCESS_CODE = -1

    // Комбинация email и password для входа
    const val USER_EMAIL = "admin@mail.ru"
    const val USER_PASSWORD = "admin"
}