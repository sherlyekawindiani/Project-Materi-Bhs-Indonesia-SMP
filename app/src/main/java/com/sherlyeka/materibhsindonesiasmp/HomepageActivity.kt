package com.sherlyeka.materibhsindonesiasmp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sherlyeka.materibhsindonesiasmp.databinding.ActivityHomepageBinding


class HomepageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomepageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

      binding.btnMulai.setOnClickListener {
            Intent( this@HomepageActivity, LoginActivity::class.java).also {
                startActivity(it)
            }
        }

    }

}