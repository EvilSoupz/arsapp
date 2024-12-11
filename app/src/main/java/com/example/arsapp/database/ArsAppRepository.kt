package com.example.arsapp.database

import com.example.arsapp.idk.BankCard
import kotlinx.coroutines.flow.Flow

interface ArsAppRepository {
    ///скопировать Dao функции


    suspend fun insertCard(bankCard: BankCardDB)
    suspend fun deleteAllCards(cardList: List<BankCardDB>)
    fun getAll():Flow<List<BankCardDB>>


}