package com.example.arsapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.arsapp.ArsAppApplication
import com.example.arsapp.ArsAppSettings
import com.example.arsapp.Notification
import com.example.arsapp.R
import com.example.arsapp.database.ArsAppRepository
import com.example.arsapp.idk.BankCard
import com.example.arsapp.idk.CardOrder
import com.example.arsapp.idk.CashBackItem
import com.example.arsapp.idk.CashBackTypes2
import com.example.arsapp.idk.toBankCard
import com.example.arsapp.idk.toCardWithCashbackDB
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch


class ArsAppViewModel(
    private val repository: ArsAppRepository
) : ViewModel() {


//
//    private val _currentSettings = MutableStateFlow<ArsAppSettings>(initialSettings)
//    val currentSettings = _currentSettings.asStateFlow()

//    val cardList = mutableListOf(
//        fakeCard, fakeCard, fakeCard, fakeCard
//    )


    private var currentSettings = repository.arsAppSettings
    var uiState by mutableStateOf(CardsUiState())
        private set


    suspend fun addCard(bankCard: BankCard) {
        repository.insertCard(bankCard.toCardWithCashbackDB())
    }

    suspend fun deleteAllCards() {
        repository.deleteAllCards(uiState.cardList.map { it.toCardWithCashbackDB() })
    }

    fun getCardList() {
        viewModelScope.launch {
//            val cards = repository.getAll().toList().first().map { it.toBankCard() }
//            uiState = CardsUiState(cardList = cards, settings = currentSettings)


        }

    }

    fun sortCardList(order: CardOrder) {
//        _currentSettings.update {
//            it.copy(
//                cardOrder = order
//            )
//        }

//        uiState.settings.cardOrder = order
        val oldState = uiState
        currentSettings.cardOrder = order
        uiState = CardsUiState(cardList = oldState.cardList, settings = currentSettings)
        //TODO sort Card List

    }

    fun changeSelectedCashBackType(type: CashBackTypes2) {
//        _currentSettings.update {
//            it.copy(
//                selectedCashBackType = type
//            )
//        }
//        uiState.settings.selectedCashBackType = type
        val oldState = uiState
        currentSettings.selectedCashBackType = type
        uiState = CardsUiState(cardList = oldState.cardList, settings = currentSettings)
    }

    fun changeLayoutToOneColumn() {
//        _currentSettings.update {
//            it.copy(
//                isGridLayout = false
//            )
//        }
//        uiState.settings.isGridLayout = false
        val oldState = uiState
        currentSettings.isGridLayout = false
        uiState = CardsUiState(cardList = oldState.cardList, settings = currentSettings)
    }

    fun changeLayoutToTwoColumn() {
//        _currentSettings.update {
//            it.copy(
//                isGridLayout = true
//            )
//        }
//        uiState.settings.isGridLayout = true
        val oldState = uiState
        currentSettings.isGridLayout = true
        uiState = CardsUiState(cardList = oldState.cardList, settings = currentSettings)
    }

    fun changeNotificationState(notification: Notification) {
//        val newList = _currentSettings.value.notificationList.apply {
//            replaceAll {
//                if (it == notification) {
//
//                    it.copy(isActive = !it.isActive)
//                } else {
//                    it
//                }
//            }
//        }
//        _currentSettings.update { settings ->
//            settings.copy(notificationList = newList)
//        }

        //////////////////////////////////////////////////
//        uiState.settings.notificationList.apply {
//            replaceAll {
//                if (it == notification) {
//
//                    it.copy(isActive = !it.isActive)
//                } else {
//                    it
//                }
//            }
//        }

        val oldState = uiState
        currentSettings.notificationList.apply {
            replaceAll {
                if (it == notification) {

                    it.copy(isActive = !it.isActive)
                } else {
                    it
                }
            }
            uiState = CardsUiState(cardList = oldState.cardList, settings = currentSettings)
        }

    }

    init {
        getCardList()
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as ArsAppApplication)
                val arsAppRepository = application.container.arsAppRepository
                ArsAppViewModel(arsAppRepository)
            }
        }
    }
}


data class CardsUiState(
    val cardList: List<BankCard> = listOf(),
    val settings: ArsAppSettings = ArsAppSettings()
)


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



