package com.example.desafioinventarioalvaro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun registrar(view:View){
        val intent = Intent(this,RegistrarActivity::class.java)
        startActivity(intent)
    }

    fun iniciar_sesion(view:View){
        val intent = Intent(this, PrincipalActivity::class.java)
        intent.putExtra("Rol",enums.Rol.JEFE_DEPARTAMENTO)
        startActivity(intent)
    }
}