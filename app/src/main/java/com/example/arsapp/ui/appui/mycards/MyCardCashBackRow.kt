package com.example.arsapp.ui.appui.mycards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.arsapp.idk.CashBackType

@Composable
fun MyCardCashBackRow(
    modifier: Modifier = Modifier,
    cashBackTypesList: List<CashBackType>,
    onItemClicked: (CashBackType) -> Unit
) {
    LazyRow(
        modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp, end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(cashBackTypesList) {
            CashBackTypeItem(item = it) {
                onItemClicked(it)
            }
        }

    }
}

@Composable
fun CashBackTypeItem(
    item: CashBackType,
    onClickAction: () -> Unit
) {

    val color = if (item.selected) {    //TODO цвета по теме
        Color.Blue
    } else {
        Color.DarkGray
    }
    Card(
        colors = CardDefaults.cardColors(containerColor = color),
        modifier = Modifier.clickable { onClickAction() },
        shape = RoundedCornerShape(100.dp)
    ) {
        Text(
            text = item.name,
            modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
        )
    }
}