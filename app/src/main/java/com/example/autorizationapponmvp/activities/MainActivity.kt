package com.example.autorizationapponmvp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.autorizationapponmvp.R

/**
 * Класс главной активности
 * (на которую попадает пользователль после авторизации/регистрации)
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}