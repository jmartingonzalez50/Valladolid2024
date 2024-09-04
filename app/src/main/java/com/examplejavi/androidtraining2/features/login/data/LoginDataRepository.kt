package com.examplejavi.androidtraining2.features.login.data

import com.examplejavi.androidtraining2.features.login.data.remote.LoginMockRemoteDataSource
import com.examplejavi.androidtraining2.features.login.domain.LoginRepository


// VA A SER LA CONCRECIÓN DE LoginRepository
// El implements de Java también es con (:)

class LoginDataRepository(private val remoteDataSource: LoginMockRemoteDataSource) : LoginRepository {

    override fun isValid(userName: String, password: String): Boolean {
        return remoteDataSource.validate(userName, password);
    }


}