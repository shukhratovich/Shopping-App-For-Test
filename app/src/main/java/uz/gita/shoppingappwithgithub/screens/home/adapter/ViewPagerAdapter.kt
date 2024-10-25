package uz.gita.shoppingappwithgithub.screens.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.shoppingappwithgithub.screens.home.fragment.BasketFragment
import uz.gita.shoppingappwithgithub.screens.home.fragment.CatalogFragment
import uz.gita.shoppingappwithgithub.screens.home.fragment.MainFragment
import uz.gita.shoppingappwithgithub.screens.home.fragment.ProfileFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private val catalogFragment = CatalogFragment()
    private val basketFragment = BasketFragment()
    private val mainFragment = MainFragment()
    private val profileFragment = ProfileFragment()
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> mainFragment
            1 -> catalogFragment
            2 -> basketFragment
            else -> profileFragment
        }
}