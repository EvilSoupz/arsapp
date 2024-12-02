package com.example.arsapp.ui.appui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.arsapp.navigation.ArsAppNavigationGraph
import com.example.arsapp.navigation.Screens
import com.example.arsapp.ui.appui.mycards.MyCardMainScreen
import com.example.arsapp.ui.theme.ArsAppTheme

@Preview
@Composable
fun MainApp() {


    val navController = rememberNavController()
    ArsAppTheme(darkTheme = true) {
        Scaffold(
            bottomBar = {

                BottomBar(
                    onMyCardClick = { navController.navigate(Screens.MyCard) },
                    onPartnersClick = { navController.navigate(Screens.Partners) },
                    onOptionsClick = { navController.navigate(Screens.Settings) },
                )


            }

        ) { paddingValues ->


            ArsAppNavigationGraph(
                navHostController = navController,
                myCardContent = { MyCardMainScreen(modifier = Modifier.padding(paddingValues)) },
                partnersContent = { /*TODO*/ },
                settingsContent = { /*TODO*/ }
            )


        }
    }


}