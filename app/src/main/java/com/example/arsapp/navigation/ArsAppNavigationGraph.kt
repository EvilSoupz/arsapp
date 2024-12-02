package com.example.arsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun ArsAppNavigationGraph (
    navHostController: NavHostController,
    myCardContent : @Composable () -> Unit,
    partnersContent : @Composable () -> Unit,
    settingsContent : @Composable () -> Unit,
){
    NavHost(navController = navHostController, startDestination = Screens.MyCard){
        composable<Screens.MyCard> {
            myCardContent()
        }
        composable<Screens.Partners> {
            partnersContent()
        }
        composable<Screens.Settings> {
            settingsContent()
        }

    }
}