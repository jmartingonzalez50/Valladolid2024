package com.examplejavi.androidtraining2.features.login.data.local

import android.content.Context

// Persistencia de datos en fichero XML
// Se va a usar una librería de Android:
//      SharedPreferences

class LoginXmlLocalDataSource (private val context: Context){


    val sharedPref = context.getSharedPreferences("username.xml", Context.MODE_PRIVATE)

    fun saveUsername(username: String){
        val editor = sharedPref.edit()
        editor.putString("key_username", username)
        editor.commit()     // se podría utilizar también editor.apply() pero es asíncrono

    }


}