package com.example.filmsapp

import android.app.Application
import android.content.Context


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        myApplication = this
    }

    companion object {
        private var myApplication: MyApplication? = null
        fun getMyApp() = myApplication!!
    }
}
