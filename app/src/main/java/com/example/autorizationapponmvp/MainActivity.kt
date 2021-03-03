package com.example.autorizationapponmvp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.autorizationapponmvp.R.layout.activity_main
import com.example.autorizationapponmvp.presenters.RegisterPresenter
import com.example.autorizationapponmvp.interfaces.RegisterPresenterInterface
import com.example.autorizationapponmvp.presenters.SignInPresenter
import com.example.autorizationapponmvp.interfaces.SignInPresenterInterface
import com.example.autorizationapponmvp.view.RegisterViewInterface
import com.example.autorizationapponmvp.view.SignInViewInterface
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SignInViewInterface, RegisterViewInterface {

    private lateinit var signInPresenter: SignInPresenterInterface
    private lateinit var registerPresenter: RegisterPresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        // Инициализация презентеров
        signInPresenter = SignInPresenter(this)
        registerPresenter = RegisterPresenter(this)

        // Обработка событий
        registerButton.setOnClickListener {
            registerPresenter.onDataValid(
                emailEditText.text.toString(),
                passwordEditText.text.toString()
            )
        }

        loginButton.setOnClickListener {
            signInPresenter.onSignIn(
                emailEditText.text.toString(),
                passwordEditText.text.toString()
            )
        }
    }

    override fun onSignInSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        // Переход на новую активность
        startActivity(Intent(this, SecondActivity::class.java))
        finish()
    }

    override fun onSignInError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDataValidSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDataValidError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}