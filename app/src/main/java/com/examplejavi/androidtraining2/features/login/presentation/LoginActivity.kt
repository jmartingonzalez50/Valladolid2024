package com.examplejavi.androidtraining2.features.login.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.examplejavi.androidtraining2.R
import com.examplejavi.androidtraining2.features.login.LoginFactory
import com.google.android.material.snackbar.Snackbar


// IMPORTANTE: EL ACTIVITY ACCEDE AL VIEWMODEL,
//      PERO NUNCA AL REVÉS (POR GESTIÓN DE MEMORIA, EL MOVIL TIENE MEMORIA LIMITADA)
// NUNCA HABRÁ UNA REFERENCIA DEL VIEWMODEL AL ACTIVITY



class LoginActivity : AppCompatActivity() {

    // CREA 2 MÉTODOS A NIVEL DE CLASE, PARA QUE TODAS LAS FUNCIONES PUEDAN ACCEDER A ELLAS
    // lateinit para indicar que se va a inicializar posteriormente
    private lateinit var loginFactory: LoginFactory
    private lateinit var loginViewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginFactory = LoginFactory(this)
        loginViewModel = loginFactory.provideLoginViewModel()

        setContentView(R.layout.activity_login)
        setupView() // Función para configurar la vista
    }
    private fun setupView(){
        val actionValidate = findViewById<Button>(R.id.action_validate)

        actionValidate.setOnClickListener {
            // El .text devuelve un objeto editable,
            //      Su método toString() nos devuelve el texto del usuario
            val userName = findViewById<EditText>(R.id.input_username).text.toString()
            val password = findViewById<EditText>(R.id.input_password).text.toString()
            val rememberIsChecked = findViewById<CheckBox>(R.id.check_remember).isChecked

            // Para pasárselo al ViewModel:
            val isValid = loginViewModel.validateClicked(userName, password, rememberIsChecked)

            if (isValid){
                // Snackbar: para mostrar un mensaje durante un tiempo
                Snackbar.make(
                        findViewById(R.id.main),
                        R.string.message_login_ok,
                        Snackbar.LENGTH_SHORT).show()
            }else{
                Snackbar.make(
                    findViewById(R.id.main),
                    R.string.message_login_fails,
                    Snackbar.LENGTH_SHORT).show()
            }
        }

    }

    override fun onResume() {
        super.onResume()

        // IMPORTANTE: primero crea toda la interfaz y se muestra y posteriormente
        // se buscará la información de sharedPreferences.

        loginViewModel.onResumed()?.let{ username ->
            // Si el username (it) no es nulo.
            findViewById<EditText>(R.id.input_username).setText(username)
        }
        /*
        loginViewModel.onResumed()?.let{
            findViewById<EditText>(R.id.input_username).setText(it)
        }
         */
    }
}