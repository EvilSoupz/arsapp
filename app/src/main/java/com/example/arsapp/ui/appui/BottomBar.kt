package com.example.arsapp.ui.appui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.arsapp.R


//придумать верхнюю границу
@Composable
fun BottomBar(
    onMyCardClick: () -> Unit,
    onPartnersClick: () -> Unit,
    onOptionsClick: () -> Unit,
    modifier: Modifier = Modifier
) {


    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.DarkGray)) {   ///TODO цвеет
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                drawLine(
                    color = Color.Gray,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 1f
                )
            })
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 10.dp)
        ) {
            BottomNavigationButton(
                imageId = R.drawable.card_vector,
                text = stringResource(R.string.my_card),
                modifier = Modifier.weight(1f),
                onClick = onMyCardClick
            )
            BottomNavigationButton(
                imageId = R.drawable.partners,
                text = stringResource(R.string.partners),
                modifier = Modifier.weight(1f),
                onClick = onPartnersClick
            )
            BottomNavigationButton(
                imageId = R.drawable.settings_1,
                text = stringResource(R.string.options),
                modifier = Modifier.weight(1f),
                onClick = onOptionsClick
            )
        }
    }


}


@Composable
fun BottomNavigationButton(
    imageId: Int,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier.size(28.dp)
        )
        Text(text = text)
    }
}


@Composable
fun BottomNavigationButton(
    imageId: ImageVector,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Image(
            imageVector = imageId,
            contentDescription = null,
            modifier = Modifier.size(28.dp)
        )
        Text(text = text)
    }
}