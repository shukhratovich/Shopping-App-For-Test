package uz.gita.shoppingappwithgithub.source.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val image: Int,
    val name: String,
    val oldPrice: String,
    val newPrice: String,
    val isFavourite: Int?,
    val isInBasket:Int?
)
