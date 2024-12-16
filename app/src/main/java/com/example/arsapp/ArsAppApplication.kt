package com.example.arsapp

import android.app.Application
import com.example.arsapp.database.ArsAppContainer
import com.example.arsapp.database.ArsAppDataContainer


class ArsAppApplication : Application() {
    lateinit var container: ArsAppContainer
    override fun onCreate() {
        super.onCreate()
        container = ArsAppDataContainer(context = this)
    }
}