package uz.gita.shoppingappwithgithub.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import uz.gita.shoppingappwithgithub.R
import uz.gita.shoppingappwithgithub.databinding.ScreenHomeBinding
import uz.gita.shoppingappwithgithub.screens.home.adapter.ViewPagerAdapter

class HomeScreen : Fragment() {
    private var _binding: ScreenHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ScreenHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.vp2.adapter = ViewPagerAdapter(requireActivity())

        binding.vp2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.navBar.selectedItemId = when (position) {
                    0 -> R.id.home
                    1 -> R.id.basket
                    2 -> R.id.catalog
                    else -> R.id.profile
                }
            }
        })
        binding.navBar.setOnItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.home -> binding.vp2.currentItem = 0
                R.id.basket -> binding.vp2.currentItem = 1
                R.id.catalog -> binding.vp2.currentItem = 2
                R.id.profile -> binding.vp2.currentItem = 3
            }
            return@setOnItemSelectedListener true
        }
        binding.vp2.isUserInputEnabled = false
    }

}