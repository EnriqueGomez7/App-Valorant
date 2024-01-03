package com.example.practica_json_2.ui

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.navigateUp
import com.example.practica_json_2.R
import com.example.practica_json_2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.recyclerview)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.drawerlayout.isDrawerOpen(GravityCompat.START)) {
                    binding.drawerlayout.closeDrawer(GravityCompat.START)
                } else {
                    if (!navController.navigateUp()){

                        val builder = AlertDialog.Builder(this@MainActivity)
                        builder.setMessage("¿Desea salir de la aplicación?")

                        builder.setNegativeButton("Si"){dialog, which ->
                            finishAffinity()
                        }

                        builder.setPositiveButton("No", null)


                        val dialog = builder.create()
                        dialog.show()
                    }

                }
            }
        })

    }

}