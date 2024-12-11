package com.example.arsapp.idk

import androidx.annotation.DrawableRes
import com.example.arsapp.database.BankCardDB
import com.example.arsapp.database.CashBackItemDB

data class BankCard(
    val cardId: Int = 0,
    @DrawableRes
    val bankImage: Int,
    val bankName: String,
    val cardName: String,
    val cashBackItems: List<CashBackItem>
)

data class CashBackItem(
    val itemId: Int = 0,
    val quantity: Int,
    val type: CashBackTypes2
)
fun BankCardDB.toBankCard() = BankCard(
    cardId = this.cardDB.cardId,
    bankImage = this.cardDB.bankImage,
    bankName = this.cardDB.bankName,
    cardName = this.cardDB.cardName,
    cashBackItems = this.cashbackItems.map { it.toCashBackItem() }
)

fun CashBackItemDB.toCashBackItem() = CashBackItem(
    itemId = this.itemId,
    quantity = this.quantity,
    type = this.type
)
