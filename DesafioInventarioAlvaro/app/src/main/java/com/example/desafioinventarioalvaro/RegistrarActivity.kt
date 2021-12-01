package com.example.desafioinventarioalvaro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class RegistrarActivity : AppCompatActivity() {
    lateinit var txtLogin:EditText
    lateinit var txtPwd:EditText
    lateinit var txtPwd2:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        txtLogin = findViewById(R.id.txtLoginRegistrar)
        txtPwd = findViewById(R.id.txtPwdRegistrar)
        txtPwd2 = findViewById(R.id.txtRepetirPwd)
    }

    fun registrar(view: View){
        var usuario = txtLogin.text.toString()
        var pwd = txtPwd.text.toString()
        var repetir = txtPwd2.text.toString()
        if(usuario.trim().isNotEmpty() && pwd.trim().isNotEmpty() && repetir.trim().isNotEmpty()){
            if(pwd.equals(repetir)){
                Toast.makeText(applicationContext, getString(R.string.SignUpCorrecto), Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(applicationContext, getString(R.string.SignUpFail), Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(applicationContext, getString(R.string.CampoVacio), Toast.LENGTH_LONG).show()
        }


    }
}