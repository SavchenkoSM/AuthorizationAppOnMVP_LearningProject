package com.example.autorizationapponmvp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.autorizationapponmvp.R.layout.activity_main
import com.example.autorizationapponmvp.presenter.LoginPresenter
import com.example.autorizationapponmvp.presenter.LoginPresenterInterface
import com.example.autorizationapponmvp.view.LoginViewInterface
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginViewInterface {
    override fun onDataSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDataError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        // Переход на новую активность
        startActivity(Intent(this, SecondActivity::class.java))
    }

    override fun onLoginError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private lateinit var loginPresenter: LoginPresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        // Инициализация презентера
        loginPresenter = LoginPresenter(this)

        // Обработка событий
        registerButton.setOnClickListener {
            loginPresenter.onData(
                emailEditText.text.toString(),
                passwordEditText.text.toString()
            )
        }

        loginButton.setOnClickListener {
            loginPresenter.onLogin(
                emailEditText.text.toString(),
                passwordEditText.text.toString()
            )
        }
    }
}