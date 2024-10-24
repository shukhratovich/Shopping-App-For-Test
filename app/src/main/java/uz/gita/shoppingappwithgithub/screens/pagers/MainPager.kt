package uz.gita.shoppingappwithgithub.screens.pagers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import uz.gita.shoppingappwithgithub.databinding.PagerMainBinding
import uz.gita.shoppingappwithgithub.screens.pagers.adapter.PagerAdapter

class MainPager : Fragment() {
    private var _binding: PagerMainBinding? = null
    private val binding = _binding!!
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PagerMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter = PagerAdapter(requireActivity())
        binding.dots.attachTo(binding.viewPager)
        binding.tvNext.setOnClickListener { binding.viewPager.currentItem++ }
        binding.tvSkip.setOnClickListener { binding.viewPager.currentItem = 3 }
        val listener = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tvSkip.isInvisible = position == 2
                binding.tvNext.isInvisible = position == 2
                binding.dots.isInvisible = position == 2
            }
        }
        binding.viewPager.registerOnPageChangeCallback(listener)
    }
}