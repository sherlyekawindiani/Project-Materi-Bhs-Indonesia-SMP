package com.sherlyeka.materibhsindonesiasmp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var  btnIntent: Button
    lateinit var  auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login);

        btnIntent = findViewById(R.id.btn_buatakun)
        btnIntent.setOnClickListener(this)

        auth = FirebaseAuth.getInstance()

        login()

    }

    override fun onClick(v: View) {
        when(v.id){

            R.id.btn_buatakun ->{
                val Login = Intent(this@LoginActivity, RegistrasiActivity::class.java)
                startActivity(Login)
            }
        }
    }

    private fun login() {
        btnkirimLogin.setOnClickListener {
            if (TextUtils.isEmpty(inputEmail.text.toString())){
                inputEmail.setError("Masukan email")
                return@setOnClickListener
            }
            else if (TextUtils.isEmpty(inputPassword.text.toString())){
                inputPassword.setError("Masukan password")
                return@setOnClickListener
            }
            auth.signInWithEmailAndPassword(inputEmail.text.toString(), inputPassword.text.toString())
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        startActivity(Intent(this@LoginActivity, ProfileActivity::class.java))
                        finish()
                    }
                    else{
                        Toast.makeText(this@LoginActivity, "Login gagal, coba lagi! ", Toast.LENGTH_LONG).show()
                    }
                }



        }
    }
}