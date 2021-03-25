package com.sherlyeka.materibhsindonesiasmp
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_registrasi.*

class RegistrasiActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var  btnIntent: Button
    lateinit var  auth: FirebaseAuth
    var databaseReference : DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrasi)

        btnIntent = findViewById(R.id.btn_login)
        btnIntent.setOnClickListener(this)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("Profilee")

        register()
    }
    override fun onClick(v: View) {
        when(v.id){

            R.id.btn_login ->{
                val Registrasi= Intent(this@RegistrasiActivity, LoginActivity::class.java)
                startActivity(Registrasi)
            }
        }
    }

    private fun register(){
        btnkirimDaftar.setOnClickListener {
            if(TextUtils.isEmpty(inputNamalengkap.text.toString())){
                inputNamalengkap.setError("Masukkan nama lengkap")
                return@setOnClickListener
            }
            else if(TextUtils.isEmpty(inputEmail.text.toString())){
                inputEmail.setError("Masukkan email")
                return@setOnClickListener
            }
            else if(TextUtils.isEmpty(inputPassword.text.toString())){
                inputPassword.setError("Masukkan password")
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(inputEmail.text.toString(), inputPassword.text.toString())
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        val currentUser =  auth.currentUser
                        val currentUserDb = databaseReference?.child((currentUser?.uid!!))
                        currentUserDb?.child("Nama lengkap")?.setValue(inputNamalengkap.text.toString())
                        Toast.makeText(this@RegistrasiActivity, "Registrasi berhasil.", Toast.LENGTH_LONG).show()
                        finish()

                    }else {
                        Toast.makeText(this@RegistrasiActivity, "Registrasi gagal, coba lagi! ", Toast.LENGTH_LONG).show()

                    }
                }
        }
    }
}