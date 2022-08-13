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
                if (MainFragment.mainFlag) {
                    navController.navigate(R.id.action_mainFragment_to_favoriteFragment)
                    MainFragment.mainFlag = false
                } else if (DetailsFragment.detailsFlag) {
                    navController.navigate(R.id.action_detailsFragment_to_favoriteFragment)
                    DetailsFragment.detailsFlag = false
                }
                true
            }

            R.id.menu_home -> {
                if (FavoriteFragment.favoriteFlag) {
                    navController.navigate(R.id.action_favoriteFragment_to_mainFragment)
                    FavoriteFragment.favoriteFlag = false
                } else if (DetailsFragment.detailsFlag) {
                    navController.navigate(R.id.action_detailsFragment_to_mainFragment)
                    DetailsFragment.detailsFlag = false
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}