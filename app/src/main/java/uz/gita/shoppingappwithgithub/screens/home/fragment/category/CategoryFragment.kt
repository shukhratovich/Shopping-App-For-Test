package uz.gita.shoppingappwithgithub.screens.home.fragment.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.gita.shoppingappwithgithub.databinding.FragmentCatalogBinding
import uz.gita.shoppingappwithgithub.screens.home.adapter.CategoryAdapter

class CategoryFragment : Fragment(), CategoryContract.View {
    private lateinit var presenter: CategoryContract.Presenter
    private lateinit var adapterCategory: CategoryAdapter
    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatalogBinding.inflate(inflater)
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

    fun init() {
        presenter = CategoryPresenter(this)
        adapterCategory = CategoryAdapter(presenter.getAllCategory())
        binding.rvCategory.adapter = adapterCategory
    }
}