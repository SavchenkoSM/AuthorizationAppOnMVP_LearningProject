package com.example.autorizationapponmvp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.autorizationapponmvp.R.layout.activity_sign_in
import com.example.autorizationapponmvp.presenters.SignInPresenter
import com.example.autorizationapponmvp.interfaces.SignInPresenterInterface
import com.example.autorizationapponmvp.views.SignInViewInterface
import kotlinx.android.synthetic.main.activity_sign_in.*

/**
 * Класс активности Авторизации
 */
class SignInActivity : AppCompatActivity(), SignInViewInterface {

    private lateinit var signInPresenter: SignInPresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_sign_in)

        // Инициализация презентера
        signInPresenter = SignInPresenter(this)

        // Обработка событий
        loginButton.setOnClickListener {
            signInPresenter.onSignIn(
                emailEditText.text.toString(),
                passwordEditText.text.toString()
            )
        }

        goToRegisterActivityButton.setOnClickListener {
            // Переход на активность Регистрации
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }
    }

    override fun onSignInSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        // Переход на Главную активность
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onSignInError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}