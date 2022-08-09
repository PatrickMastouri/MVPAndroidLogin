package com.example.mvplogin.Presenter

import com.example.mvplogin.Model.User
import com.example.mvplogin.View.ILoginView

class LoginPresenter(internal val  iLoginView: ILoginView): ILoginPresneter {
    override fun onLogin(email: String, password: String) {
        val user = User(email,password)
        val loginCode = user.isDataValid()

        if(loginCode == 0)
            iLoginView.onLoginError("Email must not be null.. !!")
        else
            if(loginCode == 1)
                iLoginView.onLoginError("Wrong Email Address.. !!")

            else
                if(loginCode == 2)
                    iLoginView.onLoginError("Password must be greater than 6.. !!")

        else
            iLoginView.onLoginSuccess("Login success..!")
    }
}