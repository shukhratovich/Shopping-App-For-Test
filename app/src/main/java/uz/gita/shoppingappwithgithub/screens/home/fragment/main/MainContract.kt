package uz.gita.shoppingappwithgithub.screens.home.fragment.main

import uz.gita.shoppingappwithgithub.source.entity.ProductEntity

interface MainContract {
    interface Model{
        fun getAllProduct():ArrayList<ProductEntity>
        fun productFavoriteChanged(productEntity: ProductEntity)
        fun productBasketChanged(productEntity: ProductEntity)
    }
    interface Presenter {
        fun favoriteClicked()
        fun getAllProduct():ArrayList<ProductEntity>
        fun productFavoriteClicked(productEntity: ProductEntity):Boolean
        fun productBasketClicked(productEntity: ProductEntity):Boolean
    }
    interface View{
        fun openFavoriteScreen()
        fun openProductScreen()
    }
}