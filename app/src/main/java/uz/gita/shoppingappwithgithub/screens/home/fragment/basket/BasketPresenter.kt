package uz.gita.shoppingappwithgithub.screens.home.fragment.basket

import uz.gita.shoppingappwithgithub.source.entity.ProductEntity

class BasketPresenter(private val view: BasketContract.View) : BasketContract.Presenter {
    private val model = BasketModel()
    override fun getBasket(): ArrayList<ProductEntity> {
        return model.getBasketProduct()
    }

    override fun productBasketClicked(productEntity: ProductEntity): Boolean {
        productEntity.isInBasket = !productEntity.isInBasket
        model.productBasketChanged(productEntity)
        return productEntity.isInBasket
    }
}