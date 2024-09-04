package com.examplejavi.androidtraining2.features.login.domain

interface LoginRepository {

    // Es el punto de acceso a la persistencia (a la fuente de datos)
    fun isValid(userName: String, password: String): Boolean
    fun saveUsername(userName: String)
}