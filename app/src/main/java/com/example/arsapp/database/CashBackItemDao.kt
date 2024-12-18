package com.example.arsapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
//@Dao
//interface CashBackItemDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(item: CashBackItemDB)
//
//    @Delete
//    suspend fun delete(item: CashBackItemDB)
//
//    @Update
//    suspend fun update(item: CashBackItemDB)
//
//    @Query("select * from `cashback item` where cardOwnerId=:cardOwnerId")
//    fun getWithOwnerId ( cardOwnerId : Int) : Flow<List<CashBackItemDB>>
//
//}