package com.example.filmsapp

import android.app.Application
import android.content.Context
import android.preference.PreferenceManager


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        myApplication = this
    }

    companion object {
        private var myApplication: MyApplication? = null
        fun getMyApp() = myApplication!!

        fun setFavorite(key: String, value: Boolean) {
            val setFavoriteShared =
                getMyApp().getSharedPreferences("favorite", Context.MODE_PRIVATE)
            setFavoriteShared.edit().putBoolean(key, value).apply()
        }

        fun getFavorite(key: String): Boolean {
            val getFavoriteShared =
                getMyApp().getSharedPreferences("favorite", Context.MODE_PRIVATE)
           return getFavoriteShared.getBoolean(key, false)
        }
    }
}
