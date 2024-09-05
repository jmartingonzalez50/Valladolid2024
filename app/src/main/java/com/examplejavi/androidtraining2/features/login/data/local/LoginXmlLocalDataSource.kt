package com.examplejavi.androidtraining2.features.login.data.local

import android.content.Context

// Persistencia de datos en fichero XML
// Se va a usar una librería de Android:
//      SharedPreferences

class LoginXmlLocalDataSource (private val context: Context){

    val sharedPref = context.getSharedPreferences("username.xml", Context.MODE_PRIVATE)
    private val keyUsername = "key_username"

    fun saveUsername(username: String){
        val editor = sharedPref.edit()
        editor.putString(keyUsername, username)
        editor.commit()     // se podría utilizar también editor.apply() pero es asíncrono

    }

    fun deleteUserName(){
        /*
        val editor = sharedPref.edit()
        editor.remove("key_username") // Se elimina esta clave del fichero
        editor.commit()
        */

        // Lo anterior sería la forma "Java", en Kotlin para simplificar
        // se podría utilizar: con el objeto que te devuelve sharedPref.edit()
        // se van a aplicar los siguientes métodos remove y commit.

        // ES EL SCOPE FUNCTION: APPLY
        sharedPref.edit().apply {
            remove(keyUsername)
            commit()
        }
    }

    // Con String? (la interrogación indica que el valor retornado puede ser nulo)
    fun getUserName(): String? {
        // segundo parámetro: opción por defecto por si no se encuentran
        // la clave en el fichero (en este caso)
        return sharedPref.getString(keyUsername, null);
    }

}