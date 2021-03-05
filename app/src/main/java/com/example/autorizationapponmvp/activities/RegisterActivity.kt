package com.example.autorizationapponmvp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.autorizationapponmvp.R
import com.example.autorizationapponmvp.interfaces.RegisterPresenterInterface
import com.example.autorizationapponmvp.presenters.RegisterPresenter
import com.example.autorizationapponmvp.views.RegisterViewInterface
import kotlinx.android.synthetic.main.activity_register.*

/**
 * Класс активности Регистрации
 */
class RegisterActivity : AppCompatActivity(), RegisterViewInterface {

    private lateinit var registerPresenter: RegisterPresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Инициализация презентера
        registerPresenter = RegisterPresenter(this)

        // Обработка событий
        registerButton.setOnClickListener {
            registerPresenter.onDataValid(
                emailEditText.text.toString(),
                passwordEditText.text.toString(),
                repeatedPasswordEditText.text.toString()
            )
        }
    }

    override fun onRegisterSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        // Переход на Главную активность
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onRegisterError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}