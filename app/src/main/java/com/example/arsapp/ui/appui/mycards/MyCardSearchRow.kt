package com.example.arsapp.ui.appui.mycards

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.arsapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCardSearchRow(
    modifier: Modifier = Modifier
) {
    var textField by remember { mutableStateOf("") }
    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        query = textField,
        onQueryChange = { textField = it },
        onSearch = {},
        active = false,
        onActiveChange = {},
        placeholder = {
            Text(text = stringResource(R.string.search))
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        shape = RoundedCornerShape(10.dp)
    ) {

    }

}