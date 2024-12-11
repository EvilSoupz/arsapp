package com.example.arsapp.database

import kotlinx.coroutines.flow.Flow

class OfflineRepository(private val bankCardDao: BankCardDao , private val cashBackItemDao: CashBackItemDao) : ArsAppRepository {
    override suspend fun insertCard(bankCard: BankCardDB) {
        bankCardDao.insert(bankCard.cardDB)
        for(item in bankCard.cashbackItems){
            cashBackItemDao.insert(item)
        }
    }



    override suspend fun deleteAllCards(cardList: List<BankCardDB>) {
      TODO()
    }


    override fun getAll(): Flow<List<BankCardDB>> = bankCardDao.getAll()
}


