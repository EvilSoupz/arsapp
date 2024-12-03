package com.example.arsapp.ui.appui.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arsapp.R

@Composable
fun SettingsTopBar(
    onBackButton: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = Modifier.fillMaxWidth()){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            BackButton(
                onBackButton = onBackButton
            )

            Spacer(modifier = Modifier.height(40.dp))
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().height(40.dp)

        ) {
            Text(
                text = stringResource(R.string.settings),
                fontSize = 17.sp
            )
        }
    }

}


@Composable
fun BackButton(
    onBackButton: () -> Unit
) {
    Row(
        modifier = Modifier
            .clickable { onBackButton() }
    ) {
        Icon(imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = null)
        Text(
            text = stringResource(R.string.back),
            fontSize = 17.sp
        )
    }
}