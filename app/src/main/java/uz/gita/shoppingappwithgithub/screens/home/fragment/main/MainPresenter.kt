package uz.gita.shoppingappwithgithub.screens.home.fragment.main

import uz.gita.shoppingappwithgithub.source.entity.ProductEntity

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {
    private val model = MainModel()
    override fun favoriteClicked() {
        view.openFavoriteScreen()
    }

    override fun getAllProduct(): ArrayList<ProductEntity> {
        return model.getAllProduct()
    }

    override fun productFavoriteClicked(productEntity: ProductEntity): Boolean {
        productEntity.isFavourite = !productEntity.isFavourite
        model.productFavoriteChanged(productEntity)
        return productEntity.isFavourite
    }
}