package com.example.deneme1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var btnLogin:androidx.appcompat.widget.AppCompatButton
    private lateinit var btnSignUp:androidx.appcompat.widget.AppCompatButton
    private lateinit var progressBar:com.google.android.material.progressindicator.CircularProgressIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin = findViewById(R.id.btnSignIn)
        btnSignUp = findViewById(R.id.btnSignUp)
        progressBar = findViewById(R.id.loading)
        btnLogin.setOnClickListener{
            val intent = Intent(this,HomePageActivity::class.java)
            resultLauncher.launch(intent)
        }
    }
    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            Log.i("MainActivity","INTENT")
            // There are no request codes
        }
    }
    private fun showAlertDialog(title: String, view: View?, positiveClickListener: View.OnClickListener) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setView(view)
            .setPositiveButton("OK") { _, _ ->
                positiveClickListener.onClick(null)
            }.show()
    }
}