package com.example.arsapp.ui.appui.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NotificationRow() {

    var cashBackUpdate by remember{ mutableStateOf(false) }
    var newOffers by remember{ mutableStateOf(false) }
    var recomendations by remember{ mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = "Уведомления")
        Card(
            shape = RoundedCornerShape(10.dp),


            ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            ) {
                Text(text = "Обновления Кэшбэка")
                Switch(checked = cashBackUpdate , onCheckedChange = { cashBackUpdate= !cashBackUpdate} )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            ) {
                Text(text = "Новые предложения")
                Switch(checked = newOffers , onCheckedChange = { newOffers= !newOffers} )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
            ) {
                Text(text = "Рекомендации")
                Switch(checked = recomendations , onCheckedChange = { recomendations= !recomendations} )
            }
        }
    }
    
}