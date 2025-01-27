package com.example.arsapp.database

import com.example.arsapp.ArsAppSettings
import com.example.arsapp.idk.CashBackTypes2
import kotlinx.coroutines.flow.Flow

class OfflineRepository(private val bankCardDao: BankCardDao) : ArsAppRepository {

    override val arsAppSettings = ArsAppSettings()

    override suspend fun insertCard(bankCard: CardWithCashbackDB) {

        bankCardDao.insertCArdWithCashBack(bankCard.cardDB, bankCard.cashbackItems)

    }


    override suspend fun deleteAllCards(cardList: List<CardWithCashbackDB>) {
        val cards = cardList.map { it.cardDB }
        val items = cardList.map { it.cashbackItems }
        bankCardDao.deleteAllCards(cards)
        items.forEach {
            bankCardDao.delete(items = it)
        }


    }


    override fun getAll(): Flow<List<CardWithCashbackDB>> = bankCardDao.getAll()


    override fun getByCBType(type: CashBackTypes2): Flow<List<CardWithCashbackDB>> =
        bankCardDao.getByCBType(type)


}