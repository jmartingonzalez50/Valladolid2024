package com.examplejavi.androidtraining2.features.login
import android.content.Context
import com.examplejavi.androidtraining2.features.login.data.LoginDataRepository
import com.examplejavi.androidtraining2.features.login.data.local.LoginXmlLocalDataSource
import com.examplejavi.androidtraining2.features.login.data.remote.LoginMockRemoteDataSource
import com.examplejavi.androidtraining2.features.login.domain.LoginRepository
import com.examplejavi.androidtraining2.features.login.domain.SaveUsernameUseCase
import com.examplejavi.androidtraining2.features.login.domain.SignInUseCase
import com.examplejavi.androidtraining2.features.login.presentation.LoginViewModel


// ES UNA FACTORY: SU ÚNICA RESPONSABILIDAD ES CREAR OBJETOS
class LoginFactory(private val context: Context) {

    // Atributos de clase

    private val loginMockRemoteDataSource: LoginMockRemoteDataSource = provideLoginMockRemoteDataSource()
    private val loginXmlLocalDataSource: LoginXmlLocalDataSource = provideLoginXmlLocalSource()
    private val loginRepository: LoginRepository = provideLoginDataRepository()
    // Tiene que estar después: sino, crash en ejecución (objeto no instanciado)
    private val signInUseCase: SignInUseCase = provideSignInUseCase()
    private val saveUsernameUseCase: SaveUsernameUseCase = provideSaveUsernameUseCase()


    fun provideLoginViewModel(): LoginViewModel{
        // Para crear una instancia de una clase:
        return LoginViewModel(signInUseCase, saveUsernameUseCase)     // LoginViewModel() es como el new de Java
    }

    private fun provideLoginMockRemoteDataSource(): LoginMockRemoteDataSource{
        return LoginMockRemoteDataSource()
    }

    private fun provideLoginDataRepository(): LoginDataRepository{
        return LoginDataRepository(loginXmlLocalDataSource, loginMockRemoteDataSource)
    }

    private fun provideLoginXmlLocalSource(): LoginXmlLocalDataSource {
        return LoginXmlLocalDataSource(context)
    }
    private fun provideSignInUseCase(): SignInUseCase{
        return SignInUseCase(loginRepository)
    }

    private fun provideSaveUsernameUseCase(): SaveUsernameUseCase{
        return SaveUsernameUseCase(loginRepository)
    }



}