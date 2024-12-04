package com.example.arsapp.ui.appui.settings

import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.arsapp.ArsAppSettings
import com.example.arsapp.CardOrder
import com.example.arsapp.ui.theme.ArsAppTheme
import com.example.arsapp.viewmodels.ArsAppViewModel

@RequiresApi(35)
@Composable
fun SettingsScreen(


    arsAppViewModel: ArsAppViewModel,
    onBackButton : ()->Unit,


    modifier: Modifier = Modifier
) {

    val currentSettings = arsAppViewModel.currentSettings.collectAsState()


    Column {
        SettingsTopBar(
            onBackButton = onBackButton
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, end = 16.dp)
        ) {
            DisplayCardsRow(
                onOneInColumnClick = { arsAppViewModel.changeLayoutToOneColumn() },
                onTwoInColumnClick = { arsAppViewModel.changeLayoutToTwoColumn() }

            )
            Spacer(modifier = Modifier.height(40.dp))
            CardOrderRow(
                onOrderClick = { arsAppViewModel.sortCardList(it) }
            )
            Spacer(modifier = Modifier.height(40.dp))
            NotificationRow(
                currentSettings.value.notificationList,   // почему не происходит рекомпозиция
                onNotificationChange = { arsAppViewModel.changeNotificationState(it)   }
            )
            Spacer(modifier = Modifier.height(40.dp))
            ResetCardButton(onResetCardButton = { arsAppViewModel.resetCardList() })
        }
    }
}





//@Preview
//@Composable
//fun SettingsPreview() {
//    ArsAppTheme(darkTheme = true) {
//        SettingsScreen()
//    }
//}