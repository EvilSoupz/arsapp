package com.example.arsapp.ui.appui.mycards

import android.widget.GridLayout
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.arsapp.ui.appui.bankCards.BankCard
import com.example.arsapp.ui.appui.bankCards.BankCardLarge
import com.example.arsapp.ui.appui.bankCards.BankCardSmall

@Composable
fun CardsZone(
    modifier: Modifier = Modifier,
    cardList: List<BankCard>,
    ifGridLayout: Boolean

) {

    Card(
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.DarkGray),  ///TODO цвета по теме
        modifier = Modifier.fillMaxSize()
    ) {

        if(ifGridLayout){
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(cardList){
                    BankCardSmall(bankCard = it)
                }
                
            }
        }
        else{
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(cardList){
                    BankCardLarge(bankCard = it)
                }
            }
            
        }


    }
}
