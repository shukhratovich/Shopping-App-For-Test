package uz.gita.shoppingappwithgithub.screens.home.fragment.category

import uz.gita.shoppingappwithgithub.source.entity.CategoryEntity

class CategoryPresenter(private val view: CategoryContract.View) : CategoryContract.Presenter {
    private val model = CategoryModel()
    override fun getAllCategory(): ArrayList<CategoryEntity> {
        return model.getAllCategory()
    }
}