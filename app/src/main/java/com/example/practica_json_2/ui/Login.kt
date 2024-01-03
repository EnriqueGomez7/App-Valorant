package com.example.practica_json_2.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practica_json_2.databinding.LoginBinding

class Login: AppCompatActivity() {

    private lateinit var binding: LoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.hide();

        binding.login.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)

        }


    }





}