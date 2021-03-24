package com.sherlyeka.materibhsindonesiasmp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class HomepageActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var  btnIntent: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage);

        btnIntent = findViewById(R.id.btn_mulai)
        btnIntent.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){

            R.id.btn_mulai ->{
                val Homepage = Intent(this@HomepageActivity, LoginActivity::class.java)
                startActivity(Homepage)
            }
        }
    }
}