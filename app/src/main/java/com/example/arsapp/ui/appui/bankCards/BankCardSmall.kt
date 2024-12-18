package com.example.arsapp.ui.appui.bankCards


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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


@Composable
fun BankCardSmall(
    bankCard: BankCard
) {
    Card(
        modifier = Modifier,
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(color = Color.LightGray, width = 1.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Row {
                Image(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .height(40.dp)
                        .width(40.dp),
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
            Spacer(modifier = Modifier.height(8.dp))
            Column(
            ) {
                Row {
                    if (bankCard.cashBackItems.size > 3) {
                        CashBackItemSmall(
                            item = bankCard.cashBackItems[3]
                        )
                    } else {
                        Spacer(
                            modifier = Modifier
                                .width(48.dp)
                                .height(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    if (bankCard.cashBackItems.size > 4) {
                        CashBackItemSmall(
                            item = bankCard.cashBackItems[4]
                        )
                    } else {
                        Spacer(
                            modifier = Modifier
                                .width(48.dp)
                                .height(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    if (bankCard.cashBackItems.size > 5) {
                        CashBackItemSmall(
                            item = bankCard.cashBackItems[5]
                        )
                    } else {
                        Spacer(
                            modifier = Modifier
                                .width(48.dp)
                                .height(24.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(6.dp))
                Row {
                    if (bankCard.cashBackItems.isNotEmpty()) {
                        CashBackItemSmall(
                            item = bankCard.cashBackItems[0]
                        )
                    } else {
                        Spacer(
                            modifier = Modifier
                                .width(48.dp)
                                .height(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    if (bankCard.cashBackItems.size > 1) {
                        CashBackItemSmall(
                            item = bankCard.cashBackItems[1]
                        )
                    } else {
                        Spacer(
                            modifier = Modifier
                                .width(48.dp)
                                .height(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    if (bankCard.cashBackItems.size > 2) {
                        CashBackItemSmall(
                            item = bankCard.cashBackItems[2]
                        )
                    } else {
                        Spacer(
                            modifier = Modifier
                                .width(48.dp)
                                .height(24.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SmallCardPreview() {
    BankCardSmall(bankCard = fakeCard)
}





