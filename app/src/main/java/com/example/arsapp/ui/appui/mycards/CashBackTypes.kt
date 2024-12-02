package com.example.arsapp.ui.appui.mycards

class CashBackType(
    val name: String,
    val selected: Boolean = false
) {

}


val fakeCashBackTypeList = listOf(
    CashBackType("Все", selected = true),
    CashBackType("Еда"),
    CashBackType("Здоровье"),
    CashBackType("Топливо"),
    CashBackType("Развлечения"),
)
