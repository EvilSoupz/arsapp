package com.example.arsapp.ui.appui.bankCards

import com.example.arsapp.R

class BankCard(
    val bankImage: Int,
    val bankName: String,
    val cardType: String,
    val cashBackItems: List<CashBackItem>
)


class CashBackItem(
    val icon: Int,
    val name: String,
    val quantity: Int
)
