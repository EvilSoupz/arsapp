package com.example.arsapp.ui.appui.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arsapp.R

@Composable
fun DisplayCardsRow(
    onOneInColumnClick: () -> Unit,
    onTwoInColumnClick: () -> Unit,
    isGridLayout: Boolean,
    modifier: Modifier = Modifier
) {
    var clickState by remember { mutableStateOf(false) }
    var textState by remember { mutableIntStateOf(R.string.one_column) }
    if (isGridLayout) {
        textState = R.string.two_column
    } else {
        textState = R.string.one_column
    }
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        clickState = !clickState
                    }
            ) {
                Text(
                    text = stringResource(R.string.dispaly_cards),
                    fontSize = 17.sp
                )
                Row {
                    Text(text = stringResource(id = textState))

                    if (clickState) {
                        Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = null)
                    } else {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = null
                        )
                    }
                }
            }
            if (clickState) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            clickState = !clickState
                            textState = R.string.one_column
                            onOneInColumnClick()
                        },
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(text = stringResource(R.string.one_column))
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            clickState = !clickState
                            textState = R.string.two_column
                            onTwoInColumnClick()
                        },
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(text = stringResource(R.string.two_column))
                }
            }
        }
    }
}