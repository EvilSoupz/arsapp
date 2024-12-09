package com.example.arsapp.ui.appui.mycards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arsapp.idk.CardOrder
import com.example.arsapp.R


@Composable
fun MyCardTopBar(
    modifier: Modifier = Modifier,
    onOrderClick: (CardOrder) -> Unit,
    onAddCardButton: () -> Unit
) {
    var sortButtonState by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier) {
            IconButton(onClick = { sortButtonState = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.group_37),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )

            }
            DropdownMenu(
                expanded = sortButtonState,
                onDismissRequest = { sortButtonState = false },
                offset = DpOffset(16.dp, 0.dp)
            ) {
                SortWindow(onOrderClick = {
                    onOrderClick(it)
                    sortButtonState = false
                })
            }
        }

        Text(
            text = stringResource(R.string.my_cards),
            fontSize = 24.sp
        )

        IconButton(onClick = { onAddCardButton() }) {
            Icon(
                painter = painterResource(id = R.drawable.add_card_ic),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )


        }

    }

}
