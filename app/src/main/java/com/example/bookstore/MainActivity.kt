package com.example.bookstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {

    private lateinit var viewPager : ViewPager
    private lateinit var tabLayout : TabLayout
    private lateinit var drawerLayout : DrawerLayout




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        drawerLayout = findViewById(R.id.drawer_layout)
        setSupportActionBar(findViewById(R.id.toolbar))

        val actionBar : ActionBar? = supportActionBar

        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }
        
        val navigationView : NavigationView = findViewById(R.id.navigation_view)
        
        navigationView.setNavigationItemSelectedListener { 
            menuItem ->
            when(menuItem.itemId){
                R.id.profile -> {
                    val intent = Intent(this@MainActivity, ProfileActivity::class.java)
                    startActivity(intent)

                }
                    R.id.about ->{
                        val intent = Intent(this@MainActivity, AboutActivity::class.java)
                        startActivity(intent)
                    }

            }
            drawerLayout.closeDrawers()
            true

        }

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tab_layout)

        val pagerAdapter = MyPageAdapter(supportFragmentManager)

        viewPager.adapter = pagerAdapter

        tabLayout.setupWithViewPager(viewPager)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item?.itemId){
            android.R.id.home ->{
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }
}