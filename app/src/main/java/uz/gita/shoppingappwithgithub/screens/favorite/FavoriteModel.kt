package uz.gita.shoppingappwithgithub.screens.favorite

import uz.gita.shoppingappwithgithub.source.AppDatabase
import uz.gita.shoppingappwithgithub.source.entity.ProductEntity

class FavoriteModel : FavoriteContract.Model {
    private val appDatabase = AppDatabase.instance
    override fun getFavoriteProduct(): ArrayList<ProductEntity> {
        return ArrayList(appDatabase.getProductDao().getAllFavoriteProduct())
    }

    override fun productFavoriteChanged(productEntity: ProductEntity) {
        appDatabase.getProductDao().update(productEntity)
    }
}