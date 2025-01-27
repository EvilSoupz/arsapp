package com.example.arsapp.ui.appui.mycards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arsapp.idk.CardOrder

@Composable
fun SortWindow(
    onOrderClick: (CardOrder) -> Unit,
    modifier: Modifier = Modifier
) {

    Column {

        for (order in CardOrder.entries) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
                    .clickable { onOrderClick(order) }
            ) {
                Text(text = order.text, fontSize = 17.sp)
            }

        }

    }

}