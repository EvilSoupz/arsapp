package com.example.arsapp.idk

class BankCard(
    val bankImage: Int,
    val bankName: String,
    val cardName: String,
    val cashBackItems: List<CashBackItem>
)


class CashBackItem(
    val quantity: Int,
    val type: CashBackTypes2
)
