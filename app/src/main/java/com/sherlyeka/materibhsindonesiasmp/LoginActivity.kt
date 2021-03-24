package com.sherlyeka.materibhsindonesiasmp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var  btnIntent: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login);

        btnIntent = findViewById(R.id.btn_buatakun)
        btnIntent.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){

            R.id.btn_buatakun ->{
                val Login = Intent(this@LoginActivity, RegistrasiActivity::class.java)
                startActivity(Login)
            }
        }
    }
}