package com.example.arsapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 20, entities = [CardDB::class, CashBackItemDB::class], exportSchema = false)
abstract class ArsAppDatabase : RoomDatabase() {
    abstract fun bankCardDao(): BankCardDao

    companion object {
        @Volatile
        private var Instance: ArsAppDatabase? = null


        fun getDatabase(context: Context): ArsAppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    ArsAppDatabase::class.java,
                    "arsapp_database"
                ).fallbackToDestructiveMigration().build().also { Instance = it }

            }
        }

    }
}