package uz.gita.shoppingappwithgithub.source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.gita.shoppingappwithgithub.source.entity.CategoryEntity

@Dao
interface CategoryDao {

    @Query("Select * from CategoryEntity")
    fun getAll(): List<CategoryEntity>

    @Insert
    fun add(category: CategoryEntity)
}