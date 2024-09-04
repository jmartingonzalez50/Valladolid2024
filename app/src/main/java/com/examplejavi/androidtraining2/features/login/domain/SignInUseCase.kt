package com.examplejavi.androidtraining2.features.login.domain



// El caso de uso recibe como parámetro en el constructor el REPOSITORIO.
// SE TIENE ACCESO A LA CAPA DE DATOS GRACIAS A LA INTERFAZ

class SignInUseCase(private val loginRepository: LoginRepository) {


    // El método invoke permite usar objetos como funciones (programación funcional)

    // El caso de uso:
    //      Recibe: el username y el password
    //      Retorna: true o false (según validación o no correcta)


    operator fun invoke(userName: String, password: String): Boolean{
        // El caso de uso le dá igual dónde persisten los datos por eso accede a partir de
        // la interfaz LoginRepository
        return loginRepository.isValid(userName, password)
    }
}