package com.example.arsapp

import com.example.arsapp.idk.CardOrder
import com.example.arsapp.idk.CashBackTypes2

data class Notification(
    val name : String,
    var isActive: Boolean=false
)

data class ArsAppSettings(
    private var cardOrder: CardOrder = CardOrder.Alphabet,
    var isGridLayout: Boolean = false,

    val notificationList: MutableList<Notification> = mutableListOf(
        Notification("Обновления Кэшбэка"),
        Notification("Новые предложения"),
        Notification("Рекомендации",true),
    ),
    var selectedCashBackType: CashBackTypes2 = CashBackTypes2.All

) {

    fun changeNotificationState ( notification: Notification){
        notificationList.replaceAll{
            if(it==notification){

                it.copy(isActive = !it.isActive)
            }
            else{

                it
            }
        }


    }


}