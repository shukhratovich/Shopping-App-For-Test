package uz.gita.shoppingappwithgithub.screens.home.fragment.category

import uz.gita.shoppingappwithgithub.source.entity.CategoryEntity

interface CategoryContract {
    interface Model {
        fun getAllCategory():ArrayList<CategoryEntity>
    }
    interface Presenter{
        fun getAllCategory():ArrayList<CategoryEntity>
    }
    interface View{

    }
}