package com.example.arsapp.idk

import com.example.arsapp.R

//class CashBackType(
//    val name: String,
//    val selected: Boolean = false
//) {
//
//}
//
//
//val fakeCashBackTypeList = listOf(
//    CashBackType("Все", selected = true),
//    CashBackType("Еда"),
//    CashBackType("Здоровье"),
//    CashBackType("Топливо"),
//    CashBackType("Развлечения"),
//)


//sealed class CashBackTypes2(val name : String){
//    class All : CashBackTypes2("Все")
//    class Food : CashBackTypes2("Еда")
//    class Health : CashBackTypes2("Здоровье")
//    class Fuel : CashBackTypes2("Топливо")
//    class Entertainment : CashBackTypes2("Развлечения")
//
//}
enum class CashBackTypes2(val typeName : String, val  icon : Int){


    All("Все", R.drawable.ic_launcher_foreground),
   Food ("ЕдаD", R.drawable.ic_launcher_foreground),
    Health("Здоровье", R.drawable.ic_launcher_foreground),
    Fuel("Топливо", R.drawable.ic_launcher_foreground),
    Entertainment("Развлечения", R.drawable.ic_launcher_foreground),;

}