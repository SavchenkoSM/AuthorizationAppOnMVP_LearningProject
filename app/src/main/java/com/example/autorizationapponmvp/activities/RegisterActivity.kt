package com.example.autorizationapponmvp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.autorizationapponmvp.R
import com.example.autorizationapponmvp.presenters.RegisterPresenter
import com.example.autorizationapponmvp.views.RegisterViewInterface
import kotlinx.android.synthetic.main.activity_register.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

/**
 * Класс активности Регистрации
 */
class RegisterActivity : MvpAppCompatActivity(), RegisterViewInterface {

    @InjectPresenter
    lateinit var registerPresenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

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