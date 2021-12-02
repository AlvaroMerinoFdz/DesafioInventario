package com.example.desafioinventarioalvaro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import enums.Rol


class PrincipalActivity : AppCompatActivity() {
    private lateinit var rol:enums.Rol
    lateinit var fragmentJefe:View
    lateinit var txtRol :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        fragmentJefe = findViewById(R.id.fragmentJefe)
        txtRol = findViewById(R.id.txtRol)

        val i = intent.extras

        rol = i?.getSerializable("Rol") as Rol

        txtRol.text = rol.toString()

        if(rol.equals(Rol.JEFE_DEPARTAMENTO)){

        }else{
            fragmentJefe.isVisible = false
        }
    }

    fun cerrarSesion(view: View){
        finish()
    }
}