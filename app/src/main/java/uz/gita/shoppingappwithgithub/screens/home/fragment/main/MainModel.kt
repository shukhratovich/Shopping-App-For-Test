package uz.gita.shoppingappwithgithub.screens.home.fragment.main

import uz.gita.shoppingappwithgithub.source.AppDatabase
import uz.gita.shoppingappwithgithub.source.entity.ProductEntity

class MainModel : MainContract.Model {
    private val appDatabase = AppDatabase.instance
    override fun getAllProduct(): ArrayList<ProductEntity> {
        return ArrayList(appDatabase.getProductDao().getAllProduct())
    }

    override fun productFavoriteChanged(productEntity: ProductEntity) {
        appDatabase.getProductDao().update(productEntity)
    }
}