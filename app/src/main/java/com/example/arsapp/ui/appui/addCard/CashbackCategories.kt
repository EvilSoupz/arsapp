package com.example.arsapp.ui.appui.addCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arsapp.R
import com.example.arsapp.idk.CashBackItem
import com.example.arsapp.idk.CashBackTypes2

@Composable
fun CashbackCategories(
    categoryList: List<CashBackItem>,
    onAddCategoryClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            categoryList.forEach {
                CategoryRow(item = it)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .clickable { onAddCategoryClick() },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.AddCircle, contentDescription = null)
                Text(text = stringResource(R.string.add_category_text))
            }
        }
    }
}

@Composable
fun CategoryRow(
    item: CashBackItem
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(item.type.icon),
            contentDescription = null,
            modifier = Modifier.height(44.dp)
        )
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = item.type.name, fontSize = 17.sp)
            Text(text = stringResource(R.string.cashback_text) + " ${item.quantity}%")
            HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
        }
    }
}
@Preview
@Composable
fun AddCategoryPreview() {
    CashbackCategories(
        listOf(
            CashBackItem(
                quantity = 1,
                type = CashBackTypes2.Food
            ),
            CashBackItem(
                quantity = 2,
                type = CashBackTypes2.Entertainment
            ),
            CashBackItem(
                quantity = 3,
                type = CashBackTypes2.Fuel
            ),
            CashBackItem(
                quantity = 4,
                type = CashBackTypes2.Health
            ),
        ),
        onAddCategoryClick = {}
    )
}