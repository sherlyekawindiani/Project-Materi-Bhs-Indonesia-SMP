package com.sherlyeka.materibhsindonesiasmp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_homepage.*



class HomepageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage);

        btn_mulai.setOnClickListener {
            Intent( this@HomepageActivity, LoginActivity::class.java).also {
                startActivity(it)
            }
        }

    }

}