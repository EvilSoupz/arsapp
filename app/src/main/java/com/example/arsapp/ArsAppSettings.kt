package com.example.arsapp

enum class CardOrder(val text: String) {
    Alphabet("По алфавиту"),
    CashBachDecrease("Кэшбэк по убыванию"),
    CashBachIncrease("Кэшбэк по возрастанию")
}

data class Notification(
    val name : String,
    var isActive: Boolean=false
)

class ArsAppSettings {
    private var cardOrder: CardOrder = CardOrder.Alphabet
    var isGridLayout: Boolean = false
        private set
    val notificationList = mutableListOf(
        Notification("Обновления Кэшбэка"),
        Notification("Новые предложения"),
        Notification("Рекомендации",true),
    )
    fun changeLayoutToOneColumn(){
        isGridLayout = false
    }fun changeLayoutToTwoColumn(){
        isGridLayout = true
    }
    fun changeCardOrder (order: CardOrder){
        cardOrder=order
    }
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