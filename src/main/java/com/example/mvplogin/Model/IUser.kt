package com.example.mvplogin.Model

interface IUser  {
    val email: String
    val password: String
    fun isDataValid(): Int

}