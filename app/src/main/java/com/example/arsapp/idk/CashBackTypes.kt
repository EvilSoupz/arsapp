package com.example.arsapp.idk

import androidx.annotation.DrawableRes
import com.example.arsapp.R

enum class CashBackTypes2(val typeName: String, @DrawableRes val icon: Int) {
    All("Все", R.drawable.ic_launcher_foreground),
    Food("ЕдаD", R.drawable.ic_launcher_foreground),
    Health("Здоровье", R.drawable.ic_launcher_foreground),
    Fuel("Топливо", R.drawable.ic_launcher_foreground),
    Entertainment("Развлечения", R.drawable.ic_launcher_foreground), ;

}