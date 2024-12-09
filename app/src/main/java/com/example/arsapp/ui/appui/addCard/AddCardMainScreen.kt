package com.example.arsapp.ui.appui.addCard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.arsapp.R
import com.example.arsapp.idk.BankCard
import com.example.arsapp.idk.CashBackItem
import com.example.arsapp.idk.CashBackTypes2
import com.example.arsapp.ui.appui.settings.SettingsTopBar

@Composable
fun AddCardMainScreen(
    onBackButton: () -> Unit,
    onSaveCardButton: (BankCard) -> Unit
) {


    var cardName by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        SettingsTopBar(
            onBackButton = onBackButton,
            centerText = stringResource(R.string.add_card)
        )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.card_name),
                modifier = Modifier.padding(start = 16.dp)
            )
            TextField(     // TODO убрать нижнее подчеркивание
                value = cardName,
                onValueChange = { cardName = it },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(unfocusedContainerColor = MaterialTheme.colorScheme.secondary),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(22.dp))
            BankChoseRow()
            Spacer(modifier = Modifier.height(40.dp))
            AddCashBackCategory()
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {
                    onSaveCardButton(
                        BankCard(
                            cardName = cardName,
                            bankName = "addBankName",
                            bankImage = R.drawable.settings,
                            cashBackItems = listOf(
                                CashBackItem(

                                    quantity = 99,
                                    type = CashBackTypes2.Entertainment
                                )
                            )
                        )
                    )
                    onBackButton()
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = stringResource(R.string.save_card))

            }
        }

    }
}


@Composable
fun BankChoseRow() {
}

@Composable
fun AddCashBackCategory() {
}

@Preview
@Composable
fun AddCardPreview() {
    AddCardMainScreen(
        onBackButton = {},
        onSaveCardButton = {}
    )
}