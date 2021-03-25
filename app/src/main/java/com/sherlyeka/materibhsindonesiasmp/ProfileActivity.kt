package com.sherlyeka.materibhsindonesiasmp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_registrasi.*

class ProfileActivity : AppCompatActivity() {
    private lateinit var  btnIntent: Button
    lateinit var  auth: FirebaseAuth
    var databaseReference : DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("Profilee")

        loadProfile()
    }

    @SuppressLint("SetTextI18n")
    private fun loadProfile(){

       val user = auth.currentUser
        val userreference = databaseReference?.child(user?.uid!!)

        EmailText.text = "Email -- >"+user?.email

        userreference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
               NamalengkapText.text = "NamaLengkap - - > "+snapshot.child( "NamaLengkap").value.toString()

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        btn_logout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this@ProfileActivity, LoginActivity::class.java))
            finish()
        }
    }
}