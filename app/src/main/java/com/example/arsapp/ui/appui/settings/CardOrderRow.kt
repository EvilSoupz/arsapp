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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arsapp.CardOrder
import com.example.arsapp.R

@Composable
fun CardOrderRow(
    onOrderClick :(CardOrder)-> Unit

) {

    var clickState by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Виджет")
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
                        text = stringResource(R.string.card_order),
                        fontSize = 17.sp
                    )


                    if (clickState) {
                        Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = null)
                    } else {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = null
                        )
                    }

                }
                if (clickState) {


                    for (state in CardOrder.entries) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    clickState = !clickState
                                    onOrderClick(state)

                                },
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(text = state.text)
                        }
                    }


                }
            }

        }
    }

}
//sealed class CardOrder( val name : String){
//    class Alphabet : CardOrder("По алфавиту")
//    class CashBachDecrease : CardOrder("Кэшбэ по убыванию")
//    class CashBachIncrease : CardOrder("Кэшбэ по возрастанию")
//}


