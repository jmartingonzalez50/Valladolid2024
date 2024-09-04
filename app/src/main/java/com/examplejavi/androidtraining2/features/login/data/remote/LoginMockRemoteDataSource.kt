package com.examplejavi.androidtraining2.features.login.data.remote


// ESTA ES LA CLASE QUE NOS VA A PERMITIR ENLAZAR CON LA TECNOLOGÍA QUE HEMOS ELEGIDO:
//      En este caso "Mock"


// UN MOCK ES UNA CLASE QUE NUNCA SE SUBE A PRODUCCIÓN. SIRVE PARA CONTINUAR EL DESARROLLO
//      HASTA QUE EL BACKEND ESTÉ PREPARADO

class LoginMockRemoteDataSource {
        private val username = "android"
        private val password = "12345"

        fun validate(userName: String, password: String): Boolean{
            return ((this.username == userName)
                    && (this.password == password ))

            // El == ES EL EQUALS DE JAVA (compara la referencia)

            // Con === se compararía las direcciones de memoria.
        }

    /* // Otra posibilidad:
    fun validate2(userName: String, password: String) =
        (this.username == userName && this.password == password )
    */

}