package com.example.mvplogin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvplogin.Presenter.ILoginPresneter
import com.example.mvplogin.Presenter.LoginPresenter
import com.example.mvplogin.View.ILoginView
import es.dmoral.toasty.Toasty


class MainActivity : AppCompatActivity(), ILoginView {
    override fun onLoginSuccess(message: String) {
       Toasty.success(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun onLoginError(message: String) {
        Toasty.error(this,message,Toast.LENGTH_SHORT).show()
    }


     lateinit var  mTextView: TextView
     lateinit var  mTextView2: TextView
     lateinit var mButton: Button



    internal lateinit var loginPresenter: ILoginPresneter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextView = findViewById(R.id.edit_email);
        mTextView2 = findViewById(R.id.edit_password);
        mButton = findViewById(R.id.btn_login);

        //init
        loginPresenter = LoginPresenter(this)

        //Event
        mButton.setOnClickListener{
            loginPresenter.onLogin(mTextView.text.toString(),mTextView2.text.toString())
        }
    }



}