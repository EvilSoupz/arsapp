package com.example.arsapp.database

import com.example.arsapp.ArsAppSettings
import com.example.arsapp.idk.CashBackTypes2
import kotlinx.coroutines.flow.Flow

interface ArsAppRepository {
    ///скопировать Dao функции
    val arsAppSettings: ArsAppSettings


    suspend fun insertCard(bankCard: CardWithCashbackDB)
    suspend fun deleteAllCards(cardList: List<CardWithCashbackDB>)
    fun getAll(): Flow<List<CardWithCashbackDB>>
    fun getByCBType(type : CashBackTypes2) : Flow<List<CardWithCashbackDB>>
}