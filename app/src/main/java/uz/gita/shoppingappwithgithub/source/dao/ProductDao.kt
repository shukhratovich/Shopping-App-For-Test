package uz.gita.shoppingappwithgithub.source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import uz.gita.shoppingappwithgithub.source.entity.ProductEntity

@Dao
interface ProductDao {
    @Query("Select * from ProductEntity")
    fun getAllProduct(): List<ProductEntity>

    @Query("Select * from ProductEntity where isInBasket = ${true}")
    fun getAllProductInBasket(): List<ProductEntity>

    @Query("Select * from ProductEntity where isFavourite = ${true}")
    fun getAllFavoriteProduct(): List<ProductEntity>

    @Insert
    fun add(product: ProductEntity)

    @Update
    fun update(product: ProductEntity)
}