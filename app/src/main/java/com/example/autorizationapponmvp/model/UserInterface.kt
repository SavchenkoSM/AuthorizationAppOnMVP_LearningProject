package com.example.autorizationapponmvp.model

interface UserInterface {
    val email: String
    val password: String

    /**
     * Метод для проверки корректности данных
     */
    fun isDataValid(): Int

    /**
     * Метод проверки, существует пользователь или нет
     */
    fun isUserExist(): Int
}