package uz.gita.shoppingappwithgithub.source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.gita.shoppingappwithgithub.source.dao.CategoryDao
import uz.gita.shoppingappwithgithub.source.dao.ProductDao
import uz.gita.shoppingappwithgithub.source.dao.UserDao
import uz.gita.shoppingappwithgithub.source.entity.CategoryEntity
import uz.gita.shoppingappwithgithub.source.entity.ProductEntity
import uz.gita.shoppingappwithgithub.source.entity.UserEntity

@Database(entities = [UserEntity::class, ProductEntity::class, CategoryEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
    abstract fun getCategoryDao(): CategoryDao
    abstract fun getProductDao(): ProductDao

    companion object {
        lateinit var instance: AppDatabase
            private set

        fun init(context: Context) {
            if (!(Companion::instance.isInitialized)) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "MyMarketApp.db")
                    .allowMainThreadQueries()
                    .build()
            }
        }
    }
}
