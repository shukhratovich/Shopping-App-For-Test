package uz.gita.shoppingappwithgithub.screens.favorite

import uz.gita.shoppingappwithgithub.source.entity.ProductEntity

interface FavoriteContract {
    interface Model {
        fun getFavoriteProduct(): ArrayList<ProductEntity>
        fun productFavoriteChanged(productEntity: ProductEntity)
    }

    interface Presenter {
        fun pressedBack()
        fun getFavorite(): ArrayList<ProductEntity>
        fun productFavoriteClicked(productEntity: ProductEntity):Boolean
    }

    interface View {
        fun goBack()
    }
}