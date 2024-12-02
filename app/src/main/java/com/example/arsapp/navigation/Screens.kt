package com.example.arsapp.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screens {
     @Serializable
     data object MyCard : Screens
     @Serializable
     data object Partners : Screens
     @Serializable
     data object Settings : Screens

}