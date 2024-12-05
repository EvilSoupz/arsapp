package com.example.arsapp.ui.appui.mycards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.arsapp.ui.theme.ArsAppTheme
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.arsapp.ArsAppSettings
import com.example.arsapp.idk.fakeCashBackTypeList
import com.example.arsapp.viewmodels.ArsAppViewModel
import com.example.arsapp.viewmodels.ArsAppViewModelFactory


@Composable
fun MyCardMainScreen(
    arsAppViewModel: ArsAppViewModel,
    modifier: Modifier = Modifier
) {

    val currentSettings = arsAppViewModel.currentSettings.collectAsState()

    Column {
        MyCardTopBar(
            onOrderClick = {   arsAppViewModel.sortCardList(it) },
            onAddCardButton = {}
        )


        MyCardSearchRow()
        Spacer(modifier = Modifier.height(10.dp))
        MyCardCashBackRow(cashBackTypesList = fakeCashBackTypeList, onItemClicked = {})
        Spacer(modifier = Modifier.height(10.dp))
        CardsZone(
            ifGridLayout = currentSettings.value.isGridLayout,
            cardList = arsAppViewModel.fakeCardList
        )
    }

}


@Preview
@Composable
fun MyCardTopBarPreview() {
    ArsAppTheme(darkTheme = true) {
        val defoltSettings = ArsAppSettings()
        val arsAppViewModel: ArsAppViewModel =
            viewModel(factory = ArsAppViewModelFactory(defoltSettings))
        MyCardMainScreen(arsAppViewModel)
//        MyCardMainScreen()
    }
}