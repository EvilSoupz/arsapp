package com.example.arsapp.ui.appui

import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDirections
import androidx.navigation.compose.rememberNavController
import com.example.arsapp.ArsAppSettings
import com.example.arsapp.navigation.ArsAppNavigationGraph
import com.example.arsapp.navigation.Screens
import com.example.arsapp.ui.appui.mycards.MyCardMainScreen
import com.example.arsapp.ui.appui.settings.SettingsScreen
import com.example.arsapp.ui.theme.ArsAppTheme
import com.example.arsapp.viewmodels.ArsAppViewModel
import com.example.arsapp.viewmodels.ArsAppViewModelFactory


@RequiresApi(35)
@Preview
@Composable
fun MainApp() {
    val navController = rememberNavController()
    val defoltSettings = ArsAppSettings()
    val arsAppViewModel: ArsAppViewModel =
        viewModel(factory = ArsAppViewModelFactory(defoltSettings))



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
                myCardContent = {
                    MyCardMainScreen(
                        arsAppViewModel = arsAppViewModel,
                        modifier = Modifier.padding(paddingValues)
                    )
                },
                partnersContent = { /*TODO*/ },
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