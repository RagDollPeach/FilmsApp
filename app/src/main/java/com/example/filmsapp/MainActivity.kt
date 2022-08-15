package com.example.filmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.filmsapp.databinding.ActivityMainBinding
import com.example.filmsapp.view.details.DetailsFragment
import com.example.filmsapp.view.favoritefragment.FavoriteAdapter
import com.example.filmsapp.view.favoritefragment.FavoriteFragment
import com.example.filmsapp.view.mainfragment.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myActivity = this
        // navController = Navigation.findNavController(this,R.id.nav_host)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_favorite -> {
                if (mainFlag) {
                    navController.navigate(R.id.action_mainFragment_to_favoriteFragment)
                    mainFlag = false
                } else if (detailsFlag) {
                    navController.navigate(R.id.action_detailsFragment_to_favoriteFragment)
                    detailsFlag = false
                }
                true
            }

            R.id.menu_home -> {
                if (favoriteFlag) {
                    navController.navigate(R.id.action_favoriteFragment_to_mainFragment)
                    favoriteFlag = false
                } else if (detailsFlag) {
                    navController.navigate(R.id.action_detailsFragment_to_mainFragment)
                    detailsFlag = false
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}