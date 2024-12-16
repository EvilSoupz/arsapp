package com.example.arsapp.idk

import androidx.annotation.DrawableRes
import com.example.arsapp.database.CardWithCashbackDB
import com.example.arsapp.database.CardDB
import com.example.arsapp.database.CashBackItemDB
import java.util.UUID

data class BankCard(
    @DrawableRes
    val bankImage: Int,
    val bankName: String,
    val cardName: String,
    val cashBackItems: List<CashBackItem>
)

data class CashBackItem(
    val quantity: Int,
    val type: CashBackTypes2
)


fun BankCard.toCardWithCashbackDB(): CardWithCashbackDB{
    val cardId = UUID.randomUUID().toString()
   return  CardWithCashbackDB(
    cardDB = CardDB(
        cardId = cardId,
        bankImage = this.bankImage,
        bankName = this.bankName,
        cardName = this.cardName
    ),
    cashbackItems = this.cashBackItems
        .map { item ->
            CashBackItemDB(
                quantity = item.quantity,
                cardOwnerId = cardId,
                type = item.type,
            )
        }
)
}


fun CardWithCashbackDB.toBankCard() = BankCard(
//    cardId = this.cardDB.cardId,
    bankImage = this.cardDB.bankImage,
    bankName = this.cardDB.bankName,
    cardName = this.cardDB.cardName,
    cashBackItems = this.cashbackItems.map { it.toCashBackItem() }
)

fun CashBackItemDB.toCashBackItem() = CashBackItem(
//    itemId = this.itemId,
    quantity = this.quantity,
    type = this.type
)
