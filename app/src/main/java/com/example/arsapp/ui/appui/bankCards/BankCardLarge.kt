package com.example.arsapp.ui.appui.bankCards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arsapp.idk.BankCard
import com.example.arsapp.viewmodels.fakeCard

@Composable
fun BankCardLarge(
    bankCard: BankCard
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(color = Color.LightGray, width = 1.dp)

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(20.dp)
        ) {
            Row {

                Image(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .height(52.dp)
                        .width(52.dp),

                    painter = painterResource(id = bankCard.bankImage),
                    contentDescription = ""
                )
                Column {
                    Text(
                        fontSize = 16.sp,
                        text = bankCard.bankName
                    )
                    Text(
                        fontSize = 16.sp,
                        text = bankCard.cardName
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if (bankCard.cashBackItems.size > 0) {
                        CashBackItemLarge(
                            item = bankCard.cashBackItems[0],


                            )
                    } else {
                        Spacer(
                            modifier = Modifier

                        )
                    }
                    if (bankCard.cashBackItems.size > 2) {
                        CashBackItemLarge(
                            item = bankCard.cashBackItems[2],


                            )
                    } else {
                        Spacer(
                            modifier = Modifier

                        )
                    }
                    if (bankCard.cashBackItems.size > 4) {
                        CashBackItemLarge(
                            item = bankCard.cashBackItems[4],


                            )
                    } else {
                        Spacer(
                            modifier = Modifier

                        )
                    }


                }
                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if (bankCard.cashBackItems.size > 1) {
                        CashBackItemLarge(
                            item = bankCard.cashBackItems[1],


                            )
                    } else {
                        Spacer(
                            modifier = Modifier

                        )
                    }
                    if (bankCard.cashBackItems.size > 3) {
                        CashBackItemLarge(
                            item = bankCard.cashBackItems[3],


                            )
                    } else {
                        Spacer(
                            modifier = Modifier

                        )
                    }
                    if (bankCard.cashBackItems.size > 5) {
                        CashBackItemLarge(
                            item = bankCard.cashBackItems[5],


                            )
                    } else {
                        Spacer(
                            modifier = Modifier

                        )
                    }

                }

            }
        }


    }

}


@Preview
@Composable
fun LargeCardPreview() {
    BankCardLarge(bankCard = fakeCard)
}





