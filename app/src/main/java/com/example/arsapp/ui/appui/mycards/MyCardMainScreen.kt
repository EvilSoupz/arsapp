package com.example.arsapp.ui.appui.mycards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.arsapp.ui.theme.ArsAppTheme
import androidx.compose.ui.unit.dp
import com.example.arsapp.ui.appui.bankCards.fakeCardList


@Composable
fun MyCardMainScreen(
    modifier: Modifier = Modifier
) {
    Column {
        MyCardTopBar(
            onSortButton = {},
            onAddCardButton = {}
        )
        Spacer(modifier = Modifier.height(10.dp))
        MyCardSearchRow()
        Spacer(modifier = Modifier.height(10.dp))
        MyCardCashBackRow(cashBackTypesList = fakeCashBackTypeList, onItemClicked = {})
        Spacer(modifier = Modifier.height(10.dp))
        CardsZone(cardList = fakeCardList)
    }


}



@Preview
@Composable
fun MyCardTopBarPreview() {
    ArsAppTheme(darkTheme = true) {
        MyCardMainScreen()
    }
}