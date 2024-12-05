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


     @Serializable
     sealed interface MyCard2 : Screens
     {
          @Serializable
          data object Main : MyCard2
          @Serializable
          data object AddCard : MyCard2
     }

}