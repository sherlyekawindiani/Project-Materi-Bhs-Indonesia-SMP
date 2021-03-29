package com.sherlyeka.materibhsindonesiasmp
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.sherlyeka.materibhsindonesiasmp.databinding.ActivityRegistrasiBinding

class RegistrasiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrasiBinding
    private lateinit var  auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnKirimDaftar.setOnClickListener {

            val email = binding.inputEmail.text.toString().trim()
            val password = binding.inputPassword.text.toString().trim()

            if (email.isEmpty()){
                binding.inputEmail.error = "Email harus diisi"
                binding.inputEmail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.inputEmail.error = "Email tidak valid"
                binding.inputEmail.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty() || password.length < 6){
                binding.inputPassword.error = "Password harus lebih dari 6 karakter"
                binding.inputPassword.requestFocus()
                return@setOnClickListener
            }

            registerUser(email, password)
        }

        binding.btnLogin.setOnClickListener {
            Intent( this@RegistrasiActivity, LoginActivity::class.java).also {
                startActivity(it)
            }
        }

    }

    private fun registerUser(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Intent(this@RegistrasiActivity, LoginActivity::class.java).also {
                        startActivity(it)
                    }
                }
                else{
                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()

                }
            }
    }

}