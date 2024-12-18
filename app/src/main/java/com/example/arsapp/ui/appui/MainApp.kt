package com.example.arsapp.ui.appui

import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.arsapp.ArsAppSettings
import com.example.arsapp.navigation.ArsAppNavigationGraph
import com.example.arsapp.navigation.Screens
import com.example.arsapp.ui.appui.addCard.AddCardMainScreen
import com.example.arsapp.ui.appui.mycards.MyCardMainScreen
import com.example.arsapp.ui.appui.settings.SettingsScreen
import com.example.arsapp.ui.theme.ArsAppTheme
import com.example.arsapp.viewmodels.ArsAppViewModel



@RequiresApi(35)
@Preview
@Composable
fun MainApp() {

    val navController = rememberNavController()
    val defoltSettings = ArsAppSettings()
//    val arsAppViewModel: ArsAppViewModel =
//        viewModel(factory = ArsAppViewModelFactory(defoltSettings))

    val arsAppViewModel : ArsAppViewModel = viewModel(factory = ArsAppViewModel.Factory)



    ArsAppTheme(darkTheme = true) {
        Scaffold(
            bottomBar = {

                BottomBar(
                    onMyCardClick = { navController.navigate(Screens.MyCard2.Main) },
                    onPartnersClick = { navController.navigate(Screens.Partners) },
                    onOptionsClick = { navController.navigate(Screens.Settings) },
                )


            }

        ) { paddingValues ->


            ArsAppNavigationGraph(
                navHostController = navController,
                myCardContent = {
                    MyCardMainScreen(
                        arsAppViewModel = arsAppViewModel,
                        onAddCardButton = { navController.navigate(Screens.MyCard2.AddCard) },
                        modifier = Modifier.padding(paddingValues)
                    )
                },
                partnersContent = { /*TODO*/ },
                addCArdContent = {
                    AddCardMainScreen(
                        onBackButton = { navController.navigateUp() },
                        viewModel = arsAppViewModel
                    )
                },
                settingsContent = {
                    SettingsScreen(
                        arsAppViewModel,
                        onBackButton = {
                            navController.navigateUp()
                        }
                    )
                }
            )


        }
    }


}