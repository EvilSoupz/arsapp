package com.example.arsapp.ui.appui.bankCards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arsapp.idk.CashBackItem

@Composable
fun CashBackItemSmall(
    item: CashBackItem,
    modifier: Modifier = Modifier.width(48.dp)
        .height(24.dp)
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.Gray),
        shape = RoundedCornerShape(40.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)

        ) {
            Image(
                modifier = Modifier
                    .width(16.dp)
                    .height(14.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = item.type.icon),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                text = "${item.quantity}%"
            )
        }
    }

}
