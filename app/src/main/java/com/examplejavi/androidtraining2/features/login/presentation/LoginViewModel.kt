package com.examplejavi.androidtraining2.features.login.presentation

import androidx.lifecycle.ViewModel
import com.examplejavi.androidtraining2.features.login.domain.SignInUseCase

// TODAS las dependencias las pasamos por CONSTRUCTOR, nunca lo creamos desde dentro.
//  ... para temas de Tests.
//      .... el primer constructor se crea entre paréntesis en el class
//      .... el resto como si fuera en Java


// EL VIEWMODEL --> Recibe el evento --> Y decide qué caso de uso se debe lanzar.
class LoginViewModel(private val signInUseCase: SignInUseCase) : ViewModel() {

    fun validateClicked(userName: String, password: String): Boolean{
        return signInUseCase.invoke(userName, password)
    }
}