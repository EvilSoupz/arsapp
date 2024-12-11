package com.example.arsapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow


@Dao
interface BankCardDao {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(bankCard: CardDB)

    @Transaction
    @Delete
    suspend fun deleteAllCards(cardList : List<CardDB>)


    @Transaction
    @Query("SELECT * from bankcard")
    fun getAll() : Flow<List<BankCardDB>>
//
//    @Query("SELECT * from bankcard WHERE cashBackItems IN (SELECT * from cashbackitem WHERE type = :type) ")  //??
//    fun getAllWithType ( type : CashBackTypes2): List<BankCard>
}
