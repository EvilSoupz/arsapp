package com.example.arsapp.database

import androidx.annotation.DrawableRes
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.example.arsapp.idk.CashBackTypes2



@Entity(tableName = "bankcard")
data class CardDB(
    @PrimaryKey(autoGenerate = true)
    val cardId: Int = 0,
    @DrawableRes
    val bankImage: Int,
    val bankName: String,
    val cardName: String,
)

@Entity(tableName = "cashback item")
data class CashBackItemDB(
    @PrimaryKey(autoGenerate = true)
    val itemId: Int = 0,
    val cardOwnerId: Int,
    val quantity: Int,
    val type: CashBackTypes2
)

data class BankCardDB(
    @Embedded
    val cardDB: CardDB,
    @Relation(parentColumn = "cardId", entityColumn ="cardOwnerId" )
    val cashbackItems: List<CashBackItemDB>

)


