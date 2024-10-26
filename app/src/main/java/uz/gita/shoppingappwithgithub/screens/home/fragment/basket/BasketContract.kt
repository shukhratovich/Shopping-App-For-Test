package uz.gita.shoppingappwithgithub.screens.home.fragment.basket

import uz.gita.shoppingappwithgithub.source.entity.ProductEntity

interface BasketContract {
    interface Model {
        fun getBasketProduct(): ArrayList<ProductEntity>
        fun productBasketChanged(productEntity: ProductEntity)
    }
    interface Presenter {
        fun getBasket(): ArrayList<ProductEntity>
        fun productBasketClicked(productEntity: ProductEntity):Boolean
    }
    interface View {}
}