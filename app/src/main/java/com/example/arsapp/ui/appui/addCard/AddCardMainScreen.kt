package com.example.arsapp.ui.appui.addCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.arsapp.R
import com.example.arsapp.idk.BankCard
import com.example.arsapp.idk.CashBackItem
import com.example.arsapp.idk.CashBackTypes2
import com.example.arsapp.ui.appui.settings.SettingsTopBar
import com.example.arsapp.viewmodels.ArsAppViewModel
import kotlinx.coroutines.launch

@Composable
fun AddCardMainScreen(
    onBackButton: () -> Unit,
    viewModel: ArsAppViewModel
) {
    val coroutinesCope = rememberCoroutineScope()
    var cardName by remember { mutableStateOf("") }
    var dialogState by remember { mutableStateOf(false) }
    var itemList by remember { mutableStateOf<List<CashBackItem>>(listOf()) }
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
            CashbackCategories(
                itemList,
                onAddCategoryClick = { dialogState = true }
            )
            if (dialogState) {
                AddCategoryDialog(
                    onDismissRequest = { dialogState = false },
                    onCategoryClick = {
                        val newList = itemList.toMutableList()
                        newList.add(it)
                        itemList = newList
                    }
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = {
                    coroutinesCope.launch {
                        viewModel.addCard(
                            BankCard(
                                cardName = cardName,
                                bankName = "addBankName",
                                bankImage = R.drawable.settings,
                                cashBackItems = itemList
                            )
                        )
                    }
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
fun AddCategoryDialog(
    onDismissRequest: () -> Unit,
    onCategoryClick: (CashBackItem) -> Unit
) {
    var cashbackQuantity by remember { mutableStateOf("0") }
    Dialog(onDismissRequest = onDismissRequest) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = cashbackQuantity,
                onValueChange = { cashbackQuantity = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            for (type in CashBackTypes2.entries) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        if (type != CashBackTypes2.All) {
                            onCategoryClick(
                                CashBackItem(quantity = cashbackQuantity.toInt(), type = type)
                            )
                            onDismissRequest()
                        }
                    }
                ) {
                    Image(
                        painter = painterResource(type.icon),
                        contentDescription = null,
                        modifier = Modifier.height(44.dp)
                    )
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(text = type.name, fontSize = 17.sp)
                        HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
                    }
                }
            }
        }
    }
}

@Composable
fun BankChoseRow() {
}

