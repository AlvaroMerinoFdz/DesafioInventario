package com.example.desafioinventarioalvaro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import api.ServiceBuilder
import api.UserApi
import modelo.Usuario
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity() {
    lateinit var login :EditText
    lateinit var pwd:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login = findViewById(R.id.txtLogin)
        pwd = findViewById(R.id.txtPwd)
    }

    fun registrar(view:View){
        val intent = Intent(this,RegistrarActivity::class.java)
        startActivity(intent)
    }

    fun iniciar_sesion(view:View){
        var usuario = login.text.toString()
        var pass = pwd.text.toString()
        val us = Usuario(usuario,"",pass)
        val request = ServiceBuilder.buildService(UserApi::class.java)
        val call = request.loginUsuario(us)

       /* val intent = Intent(this, PrincipalActivity::class.java)
        //intent.putExtra("Rol",enums.Rol.JEFE_DEPARTAMENTO)
        startActivity(intent)*/
    }
}