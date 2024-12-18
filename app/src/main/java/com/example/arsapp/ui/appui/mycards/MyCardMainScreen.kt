package com.example.arsapp.ui.appui.mycards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.arsapp.ui.theme.ArsAppTheme
import com.example.arsapp.viewmodels.ArsAppViewModel


@Composable
fun MyCardMainScreen(
    arsAppViewModel: ArsAppViewModel,
    onAddCardButton: () -> Unit,
    modifier: Modifier = Modifier
) {

    val currentSettings = arsAppViewModel.currentSettings.collectAsState()
    val uiState = arsAppViewModel.cardListState.collectAsState().value
    Column {
        MyCardTopBar(
            onOrderClick = { arsAppViewModel.sortCardList(it) },
            onAddCardButton = onAddCardButton
        )
        MyCardSearchRow()
        Spacer(modifier = Modifier.height(10.dp))
        MyCardCashBackRow(
            onItemClicked = { arsAppViewModel.changeSelectedCashBackType(it) },
            selectedType = currentSettings.value.selectedCashBackType
        )
        Spacer(modifier = Modifier.height(10.dp))
        CardsZone(
            ifGridLayout = currentSettings.value.isGridLayout,
            cardList = uiState.cardList
        )
    }

}


@Preview
@Composable
fun MyCardTopBarPreview() {
    ArsAppTheme(darkTheme = true) {
        val arsAppViewModel: ArsAppViewModel =
            viewModel(factory = ArsAppViewModel.Factory)
        MyCardMainScreen(arsAppViewModel, onAddCardButton = {})
//        MyCardMainScreen()
    }
}