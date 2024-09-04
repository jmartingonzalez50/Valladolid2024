package com.examplejavi.androidtraining2.features.login
import com.examplejavi.androidtraining2.features.login.data.LoginDataRepository
import com.examplejavi.androidtraining2.features.login.data.remote.LoginMockRemoteDataSource
import com.examplejavi.androidtraining2.features.login.domain.LoginRepository
import com.examplejavi.androidtraining2.features.login.domain.SignInUseCase
import com.examplejavi.androidtraining2.features.login.presentation.LoginViewModel


// ES UNA FACTORY: SU ÚNICA RESPONSABILIDAD ES CREAR OBJETOS
class LoginFactory {

    // Atributos de clase

    private val loginMockRemoteDataSource: LoginMockRemoteDataSource = provideLoginMockRemoteDataSource()
    private val loginRepository: LoginRepository = provideLoginDataRepository()
    // Tiene que estar después: sino, crash en ejecución (objeto no instanciado)
    private val signInUseCase: SignInUseCase = provideSignInUseCase()


    fun provideLoginViewModel(): LoginViewModel{
        // Para crear una instancia de una clase:
        return LoginViewModel(signInUseCase)     // LoginViewModel() es como el new de Java
    }

    private fun provideLoginMockRemoteDataSource(): LoginMockRemoteDataSource{
        return LoginMockRemoteDataSource()
    }

    private fun provideLoginDataRepository(): LoginDataRepository{
        return LoginDataRepository(loginMockRemoteDataSource)
    }

    private fun provideSignInUseCase(): SignInUseCase{
        return SignInUseCase(loginRepository)
    }



}