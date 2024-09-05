package com.examplejavi.androidtraining2.features.login.presentation

import androidx.lifecycle.ViewModel
import com.examplejavi.androidtraining2.features.login.domain.DeleteUsernameUseCase
import com.examplejavi.androidtraining2.features.login.domain.GetUsernameUseCase
import com.examplejavi.androidtraining2.features.login.domain.SaveUsernameUseCase
import com.examplejavi.androidtraining2.features.login.domain.SignInUseCase

// TODAS las dependencias las pasamos por CONSTRUCTOR, nunca lo creamos desde dentro.
//  ... para temas de Tests.
//      .... el primer constructor se crea entre paréntesis en el class
//      .... el resto como si fuera en Java


// EL VIEWMODEL --> Recibe el evento --> Y decide qué caso de uso se debe lanzar.
class LoginViewModel(
            private val signInUseCase: SignInUseCase,
            private val saveUsernameUseCase: SaveUsernameUseCase,
            private val deleteUsernameUseCase: DeleteUsernameUseCase,
            private val getUsernameUseCase: GetUsernameUseCase
        ) : ViewModel() {


    fun validateClicked(userName: String, password: String, isRememberChecked: Boolean): Boolean{
        if (isRememberChecked){
            saveUsernameUseCase.invoke(userName)
        }else{
            deleteUsernameUseCase.invoke()
        }
        return signInUseCase.invoke(userName, password)

    }

    fun onResumed(): String?{
        // SE LE DELEGA AL VIEWMODEL QUE REALICE ALGO EN EL ESTADO "RESUME"
        return getUsernameUseCase.invoke()

    }
}