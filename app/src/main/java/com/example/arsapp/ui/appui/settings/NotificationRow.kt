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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.arsapp.Notification

@Composable
fun NotificationRow(
    notificationsList: List<Notification>,
    onNotificationChange: (Notification) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = "Уведомления")
        Card(
            shape = RoundedCornerShape(10.dp),
        ) {
            for (notification in notificationsList) {
                var checkState by remember { mutableStateOf(notification.isActive) }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
                ) {
                    Text(text = notification.name)
                    Switch(checked = checkState, onCheckedChange = {
                        checkState = it
                        onNotificationChange(notification)
                    }
                    )
                }
            }
        }
    }
}