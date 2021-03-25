package com.sherlyeka.materibhsindonesiasmp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.sherlyeka.materibhsindonesiasmp.R.id.btn_mulai


class HomepageActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var  btnIntent: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage);

        btnIntent = findViewById(btn_mulai)
        btnIntent.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){

            btn_mulai ->{
                val Homepage = Intent(this@HomepageActivity, LoginActivity::class.java)
                startActivity(Homepage)
            }
        }
    }
}