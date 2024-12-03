package com.example.arsapp.ui.appui.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.arsapp.ui.theme.ArsAppTheme

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier
) {


    Column {
        SettingsTopBar(
            onBackButton = { /*TODO*/ }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, end = 16.dp)
        ) {
            DisplayCardsRow()
            Spacer(modifier = Modifier.height(40.dp))
            CardOrderRow()
            Spacer(modifier = Modifier.height(40.dp))
            NotificationRow()
            Spacer(modifier = Modifier.height(40.dp))
            ResetCardButton(onResetCardButton = {/*TODO*/ })
        }
    }
}





@Preview
@Composable
fun SettingsPreview() {
    ArsAppTheme(darkTheme = true) {
        SettingsScreen()
    }
}