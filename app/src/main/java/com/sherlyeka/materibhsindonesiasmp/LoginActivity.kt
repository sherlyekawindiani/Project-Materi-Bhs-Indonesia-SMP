package com.sherlyeka.materibhsindonesiasmp

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.sherlyeka.materibhsindonesiasmp.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

       binding.btnKirimLogin.setOnClickListener {
            val email = binding.inputEmail.text.toString().trim()
            val password = binding.inputPassword.text.toString().trim()

            if (email.isEmpty()) {
                binding.inputEmail.error = "Email harus diisi"
                binding.inputEmail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.inputEmail.error = "Email tidak valid"
                binding.inputEmail.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty() || password.length < 6) {
                binding.inputPassword.error = "Password harus lebih dari 6 karakter"
                binding.inputPassword.requestFocus()
                return@setOnClickListener
            }
            LoginUser(email, password)
        }

       binding.btnBuatAkun.setOnClickListener {
            Intent(this@LoginActivity, RegistrasiActivity::class.java).also {
                startActivity(it)
            }
        }

    }

    private fun LoginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { it ->
                    if (it.isSuccessful) {
                        Intent(this@LoginActivity, HalamanUserActivity::class.java).also {
                            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or  Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(it)
                        }
                    } else {
                        Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
    }




}