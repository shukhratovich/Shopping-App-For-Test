package uz.gita.shoppingappwithgithub.screens.home.fragment.category

import uz.gita.shoppingappwithgithub.source.AppDatabase
import uz.gita.shoppingappwithgithub.source.entity.CategoryEntity

class CategoryModel : CategoryContract.Model {
    private val appDatabase = AppDatabase.instance
    override fun getAllCategory(): ArrayList<CategoryEntity> {
        return ArrayList(appDatabase.getCategoryDao().getAll())
    }
}