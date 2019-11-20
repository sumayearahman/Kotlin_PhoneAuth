package com.sumayea.kotlin_phoneauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        btn_signOut.setOnClickListener {
                view: View? -> mAuth.signOut()
            startActivity(Intent(this, PhoneAuthentication::class.java))
            Toast.makeText(this, "Logged out Successfully :)", Toast.LENGTH_LONG).show()
        }
    }


    override fun onStart() {
        super.onStart()

        if (mAuth.currentUser == null) {
            startActivity(Intent(this, PhoneAuthentication::class.java))
        }
        else {
            Toast.makeText(this, "Already Signed in :)", Toast.LENGTH_LONG).show()
        }

    }
}
