package com.example.educacionitproyectovistas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navigationView: NavigationView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configuracionToolbar()

        lanzamientoMenu()


    }

    private fun lanzamientoMenu() {
        drawerLayout = findViewById(R.id.drawerLayout)
        val drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        navigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener {

            when (it.itemId){
                R.id.menu_categorias -> startNewActivity()
                R.id.menu_salir -> finish()
            }

            drawerLayout.closeDrawers()

            true

        }
    }

    private fun startNewActivity(){
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

    private fun configuracionToolbar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


}