package uz.gita.shoppingappwithgithub.screens.pagers

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import uz.gita.shoppingappwithgithub.databinding.PagerMainBinding
import uz.gita.shoppingappwithgithub.screens.pagers.adapter.PagerAdapter
import uz.gita.shoppingappwithgithub.source.MyPref

class MainPager : Fragment() {
    private var _binding: PagerMainBinding? = null
    private val binding get() = _binding!!
    override fun onDestroyView() {
        super.onDestroyView()
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
        binding.tvSkip.setOnClickListener {
            binding.viewPager.currentItem = 3
            MyPref.userFirstVisit(true)
        }
        val listener = object : ViewPager2.OnPageChangeCallback() {
            @SuppressLint("SetTextI18n")
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tvSkip.isInvisible = position == 2
                binding.dots.isInvisible = position == 2
                if (position == 2) {
                    MyPref.userFirstVisit(true)
                    binding.tvNext.text = "Done"
                    binding.tvNext.setOnClickListener {
                        findNavController().navigate(MainPagerDirections.actionMainPagerToHomeScreen())
                    }
                }
            }
        }
        binding.viewPager.registerOnPageChangeCallback(listener)
    }
}