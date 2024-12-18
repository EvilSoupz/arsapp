package com.example.arsapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface BankCardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(bankCard: CardDB)

    @Delete
    suspend fun delete(bankCard: CardDB)

    @Delete
    suspend fun deleteAllCards(cardList: List<CardDB>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCashbackList(cashbackList: List<CashBackItemDB>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCArdWithCashBack(card: CardDB, cashbackList: List<CashBackItemDB>)

    @Delete
    suspend fun delete(item: CashBackItemDB)

    @Delete
    suspend fun delete(items: List<CashBackItemDB>)

    @Update
    suspend fun update(item: CashBackItemDB)

    @Transaction
    @Query("SELECT * from bankcard")
    fun getAll(): Flow<List<CardWithCashbackDB>>
}
