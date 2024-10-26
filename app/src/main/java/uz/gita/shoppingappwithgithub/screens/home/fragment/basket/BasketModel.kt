package uz.gita.shoppingappwithgithub.screens.home.fragment.basket

import uz.gita.shoppingappwithgithub.source.AppDatabase
import uz.gita.shoppingappwithgithub.source.entity.ProductEntity

class BasketModel : BasketContract.Model {
    private val appDatabase = AppDatabase.instance
    override fun getBasketProduct(): ArrayList<ProductEntity> {
        return ArrayList(appDatabase.getProductDao().getAllProductInBasket())
    }

    override fun productBasketChanged(productEntity: ProductEntity) {
        appDatabase.getProductDao().update(productEntity)
    }
}