package uz.gita.shoppingappwithgithub.screens.home.fragment.basket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.gita.shoppingappwithgithub.databinding.FragmentBasketBinding

class BasketFragment : Fragment(), BasketContract.View {
    private lateinit var presenter: BasketContract.Presenter
    private lateinit var adapterBasket: BasketListAdapter
    private var _binding: FragmentBasketBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBasketBinding.inflate(inflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = BasketPresenter(this)
        init()
    }
}