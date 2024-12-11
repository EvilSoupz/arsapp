package com.example.arsapp.database

import android.content.Context

interface AppContainer {
    val arsAppRepository: ArsAppRepository
}


class AppDataContainer(private val context: Context) : AppContainer {

    override val arsAppRepository: ArsAppRepository by lazy {
        OfflineRepository(
            ArsAppDatabase.getDatabase(context).bankCardDao(),
            cashBackItemDao = ArsAppDatabase.getDatabase(context).cashbackItemDao()
        )
    }
}