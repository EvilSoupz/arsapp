package com.example.arsapp.database

import android.content.Context
import com.example.arsapp.ArsAppSettings

interface ArsAppContainer {
    val arsAppRepository: ArsAppRepository

}


class ArsAppDataContainer(private val context: Context) : ArsAppContainer {

    override val arsAppRepository: ArsAppRepository by lazy {
        OfflineRepository(
            ArsAppDatabase.getDatabase(context).bankCardDao()
        )
    }




}