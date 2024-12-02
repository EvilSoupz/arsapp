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
val fakeCard = BankCard(
    bankImage = R.drawable.ic_launcher_foreground,
    bankName = "BankName",
    cardType = "CardType",
    cashBackItems = listOf(
        CashBackItem(
            icon = R.drawable.ic_launcher_foreground,
            name = "CashBack",
            quantity = 1
        ),
        CashBackItem(
            icon = R.drawable.ic_launcher_foreground,
            name = "CashBack",
            quantity = 2
        ),
        CashBackItem(
            icon = R.drawable.ic_launcher_foreground,
            name = "CashBack",
            quantity = 3
        ),
        CashBackItem(
            icon = R.drawable.ic_launcher_foreground,
            name = "CashBack",
            quantity = 4
        ),
        CashBackItem(
            icon = R.drawable.ic_launcher_foreground,
            name = "CashBack",
            quantity = 5
        ),
//        CashBackItem(
//            icon = R.drawable.ic_launcher_foreground,
//            name = "CashBackItem",
//            quantity = 6
//        ),

    )
)


val fakeCardList = listOf(
    fakeCard, fakeCard, fakeCard, fakeCard

)