package com.example.arsapp.database

import androidx.annotation.DrawableRes
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.example.arsapp.idk.CashBackTypes2
import java.util.UUID


@Entity(tableName = "bankcard")
data class CardDB(
    @PrimaryKey
    val cardId: String,
    @DrawableRes
    val bankImage: Int,
    val bankName: String,
    val cardName: String,
)

@Entity(tableName = "cashback item")
data class CashBackItemDB(
    @PrimaryKey
    val itemId: String = UUID.randomUUID().toString(),
    val cardOwnerId: String,
    val quantity: Int,
    val type: CashBackTypes2
)

data class CardWithCashbackDB(
    @Embedded
    val cardDB: CardDB,
    @Relation(parentColumn = "cardId", entityColumn = "cardOwnerId")
    val cashbackItems: List<CashBackItemDB>
)


