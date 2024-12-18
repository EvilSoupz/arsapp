package com.example.arsapp.viewmodels

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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update


class ArsAppViewModel(
    private val repository: ArsAppRepository
) : ViewModel() {


    private val _currentSettings = MutableStateFlow<ArsAppSettings>(repository.arsAppSettings)
    val currentSettings = _currentSettings.asStateFlow()

    val cardListState = repository.getAll().map { cards ->
        CardsUiState(cardList = cards.map { it.toBankCard() })

    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
        initialValue = CardsUiState()
    )

    suspend fun addCard(bankCard: BankCard) {
        repository.insertCard(bankCard.toCardWithCashbackDB())
    }

    suspend fun deleteAllCards() {
        repository.deleteAllCards(cardListState.value.cardList.map { it.toCardWithCashbackDB() })
    }
    fun sortCardList(order: CardOrder) {
        _currentSettings.update {
            it.copy(
                cardOrder = order
            )
        }



        //TODO sort Card List

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
//    val settings: ArsAppSettings = ArsAppSettings()
)






