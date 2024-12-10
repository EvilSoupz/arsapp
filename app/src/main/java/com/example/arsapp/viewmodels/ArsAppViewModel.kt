package com.example.arsapp.viewmodels

import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.arsapp.ArsAppSettings
import com.example.arsapp.Notification
import com.example.arsapp.R
import com.example.arsapp.idk.BankCard
import com.example.arsapp.idk.CardOrder
import com.example.arsapp.idk.CashBackItem
import com.example.arsapp.idk.CashBackTypes2
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class ArsAppViewModel(private val arsAppSettings: ArsAppSettings) : ViewModel() {


    private val _currentSettings = MutableStateFlow<ArsAppSettings>(arsAppSettings)
    val currentSettings = _currentSettings.asStateFlow()


    val fakeCardList = mutableListOf(
        fakeCard, fakeCard, fakeCard, fakeCard
    )


    fun addCard(bankCard: BankCard) {
        fakeCardList.add(bankCard)
    }

    fun sortCardList(order: CardOrder) {
        _currentSettings.update {
            it.copy(
                cardOrder = order
            )
        }
        //TODO sort Card List

    }

    @RequiresApi(35)
    fun resetCardList() {
        while (fakeCardList.size > 0) {
            fakeCardList.removeLast()
        }
    }

    fun changeSelectedCashBackType(type: CashBackTypes2) {

        _currentSettings.update {
            it.copy(
                selectedCashBackType = type
            )
        }


    }

    fun changeLayoutToOneColumn() {
        _currentSettings.update {
            it.copy(
                isGridLayout = false
            )
        }
    }

    fun changeLayoutToTwoColumn() {
        _currentSettings.update {
            it.copy(
                isGridLayout = true
            )
        }
    }

    fun changeNotificationState(notification: Notification) {
//        _currentSettings.value.changeNotificationState(notification)

        val newList = _currentSettings.value.notificationList.apply {
            replaceAll {
                if (it == notification) {

                    it.copy(isActive = !it.isActive)
                } else {
                    it
                }
            }
        }
        _currentSettings.update { settings ->
            settings.copy(notificationList = newList)
        }
    }
}

class ArsAppViewModelFactory(private val arsAppSettings: ArsAppSettings) :
    ViewModelProvider.Factory {
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

            type = CashBackTypes2.Food,
            quantity = 1
        ),
        CashBackItem(

            type = CashBackTypes2.Fuel,
            quantity = 2
        ),
        CashBackItem(

            type = CashBackTypes2.Health,
            quantity = 3
        ),
        CashBackItem(

            type = CashBackTypes2.Entertainment,
            quantity = 4
        ),
//        CashBackItem(
//
//            type = CashBackTypes2.Food,
//            quantity = 5
//        ),
//        CashBackItem(
//
//            name = "CashBackItem",
//            quantity = 6
//        ),

    )
)



