package uz.gita.shoppingappwithgithub.screens.favorite

import uz.gita.shoppingappwithgithub.source.entity.ProductEntity

class FavoritePresenter(private val view: FavoriteContract.View) : FavoriteContract.Presenter {
    private val model = FavoriteModel()
    override fun pressedBack() {
        view.goBack()
    }

    override fun getFavorite(): ArrayList<ProductEntity> {
        return model.getFavoriteProduct()
    }

    override fun productFavoriteClicked(productEntity: ProductEntity): Boolean {
        productEntity.isFavourite = !productEntity.isFavourite
        model.productFavoriteChanged(productEntity)
        return productEntity.isFavourite
    }
}