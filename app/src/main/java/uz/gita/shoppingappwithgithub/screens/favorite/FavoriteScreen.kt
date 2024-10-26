package uz.gita.shoppingappwithgithub.screens.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.gita.shoppingappwithgithub.databinding.ScreenFavoriteBinding
import uz.gita.shoppingappwithgithub.screens.favorite.adapter.FavoriteListAdapter

class FavoriteScreen : Fragment(), FavoriteContract.View {
    private lateinit var presenter: FavoriteContract.Presenter
    private lateinit var adapterFavorite: FavoriteListAdapter
    private var _binding: ScreenFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ScreenFavoriteBinding.inflate(inflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = FavoritePresenter(this)
        init()
    }

    private fun init() {
        adapterFavorite = FavoriteListAdapter()
        adapterFavorite.submitList(presenter.getFavorite())
        binding.rvFavorite.adapter = adapterFavorite
        adapterFavorite.changeFavouriteStateListener = {
            presenter.productFavoriteClicked(it)
        }
        binding.ivBack.setOnClickListener { presenter.pressedBack() }
    }

    override fun goBack() {
        findNavController().popBackStack()
    }

}