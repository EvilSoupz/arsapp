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
    addCArdContent : @Composable ()->Unit
){
    NavHost(navController = navHostController, startDestination = Screens.MyCard2.Main){
        composable<Screens.MyCard2.Main> {
            myCardContent()
        }
        composable<Screens.MyCard2.AddCard> {
            addCArdContent()
        }
        composable<Screens.Partners> {
            partnersContent()
        }
        composable<Screens.Settings> {
            settingsContent()
        }

    }
}