package com.example.arsapp.ui.appui.mycards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.arsapp.R
import com.example.arsapp.ui.theme.ArsAppTheme


@Composable
fun MyCardTopBar(
    modifier: Modifier = Modifier,
    onSortButton: () -> Unit,
    onAddCardButton: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { onSortButton() }) {
            Icon(painter = painterResource(id = R.drawable.group_37), contentDescription = null)

        }
        Text(text = stringResource(R.string.my_cards))

        IconButton(onClick = { onAddCardButton() }) {
            Icon(painter = painterResource(id = R.drawable.add_card_ic), contentDescription = null)


        }

    }

}
