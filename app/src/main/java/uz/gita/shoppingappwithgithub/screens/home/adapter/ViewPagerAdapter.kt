package uz.gita.shoppingappwithgithub.screens.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.shoppingappwithgithub.screens.home.fragment.basket.BasketFragment
import uz.gita.shoppingappwithgithub.screens.home.fragment.category.CategoryFragment
import uz.gita.shoppingappwithgithub.screens.home.fragment.main.MainFragment
import uz.gita.shoppingappwithgithub.screens.home.fragment.profile.ProfileFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private val categoryFragment = CategoryFragment()
    private val basketFragment = BasketFragment()
    private val mainFragment = MainFragment()
    private val profileFragment = ProfileFragment()
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> mainFragment
            1 -> basketFragment
            2 -> categoryFragment
            else -> profileFragment
        }
}