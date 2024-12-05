package com.example.arsapp.viewmodels

import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.arsapp.ArsAppSettings
import com.example.arsapp.CardOrder
import com.example.arsapp.Notification
import com.example.arsapp.R
import com.example.arsapp.idk.BankCard
import com.example.arsapp.idk.CashBackItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class ArsAppViewModel(private val arsAppSettings: ArsAppSettings) : ViewModel() {


    private val _currentSettings = MutableStateFlow<ArsAppSettings>(arsAppSettings)
    val currentSettings =_currentSettings.asStateFlow()




    val fakeCardList = mutableListOf(
        fakeCard, fakeCard, fakeCard, fakeCard
    )



    fun addCard(bankCard: BankCard){
        fakeCardList.add(bankCard)
    }
    fun sortCardList(order: CardOrder){
//        arsAppSettings.changeCardOrder(order)
        _currentSettings.value.changeCardOrder(order)
        //TODO sort Card List

    }
    @RequiresApi(35)
    fun resetCardList(){
        while (fakeCardList.size>0){
            fakeCardList.removeLast()
        }
    }

    fun changeLayoutToOneColumn() {
       _currentSettings.value.changeLayoutToOneColumn()
    }

    fun changeLayoutToTwoColumn() {
        _currentSettings.value.changeLayoutToTwoColumn()
    }

    fun changeNotificationState(it: Notification) {
        _currentSettings.value.changeNotificationState(it)

    }


}

class ArsAppViewModelFactory(private val arsAppSettings: ArsAppSettings) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArsAppViewModel(arsAppSettings) as T
    }
}


val fakeCard = BankCard(
    bankImage = R.drawable.ic_launcher_foreground,
    bankName = "BankName",
    cardName = "CardType",
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



