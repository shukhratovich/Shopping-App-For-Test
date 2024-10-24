package uz.gita.shoppingappwithgithub.screens.pagers.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.shoppingappwithgithub.screens.pagers.Page1
import uz.gita.shoppingappwithgithub.screens.pagers.Page2
import uz.gita.shoppingappwithgithub.screens.pagers.Page3

class PagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> Page1()
            1 -> Page2()
            else -> Page3()
        }
}