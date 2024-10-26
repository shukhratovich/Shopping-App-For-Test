package uz.gita.shoppingappwithgithub.screens.home.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.gita.shoppingappwithgithub.databinding.FragmentMainBinding
import uz.gita.shoppingappwithgithub.screens.home.HomeScreenDirections
import uz.gita.shoppingappwithgithub.screens.home.adapter.AdvAdapter
import uz.gita.shoppingappwithgithub.screens.home.adapter.OfferAdapter
import uz.gita.shoppingappwithgithub.screens.home.adapter.ProductAdapter

class MainFragment : Fragment(), MainContract.View {
    private lateinit var presenter: MainContract.Presenter
    private lateinit var adapterAdv: AdvAdapter
    private lateinit var adapterOffer: OfferAdapter
    private lateinit var adapterProduct: ProductAdapter
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = MainPresenter(this)
        init()
    }

    fun init() {
        adapterAdv = AdvAdapter()
        adapterOffer = OfferAdapter()
        adapterProduct = ProductAdapter(presenter.getAllProduct())
        binding.rvProduct.adapter = adapterProduct
        binding.rvAdvertising.adapter = adapterAdv
        binding.rvOffers.adapter = adapterOffer
        binding.ivFavorite.setOnClickListener {
            presenter.favoriteClicked()
        }
        adapterProduct.itemFavoriteClickListener = {
            presenter.productFavoriteClicked(it)
        }
        adapterProduct.itemBasketClickListener = {
            presenter.productBasketClicked(it)
        }
    }

    override fun openFavoriteScreen() {
        findNavController().navigate(HomeScreenDirections.actionHomeScreenToFavoriteScreen2())
    }

    override fun openProductScreen() {
        TODO("Not yet implemented")
    }
}