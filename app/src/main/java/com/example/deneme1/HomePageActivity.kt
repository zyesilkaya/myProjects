package com.example.deneme1

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

private lateinit var toggle: ActionBarDrawerToggle
private lateinit var drawerLayout: DrawerLayout
private lateinit var navigationView: NavigationView

class HomePageActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.hpNavView)

        toggle = ActionBarDrawerToggle(this, drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.dmMenu-> Toast.makeText(applicationContext,"Clicked Menu",Toast.LENGTH_SHORT).show()
                R.id.dmEmployees-> Toast.makeText(applicationContext,"Clicked Employees",Toast.LENGTH_SHORT).show()
                R.id.dmLogout-> Toast.makeText(applicationContext,"Clicked Logout",Toast.LENGTH_SHORT).show()
                R.id.dmProfile-> Toast.makeText(applicationContext,"Clicked Profile",Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return false
    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }

    }
}
