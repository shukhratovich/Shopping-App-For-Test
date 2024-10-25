package uz.gita.shoppingappwithgithub.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.gita.shoppingappwithgithub.databinding.ScreenLoginBinding
import uz.gita.shoppingappwithgithub.source.entity.UserEntity

class LoginScreen : Fragment(), LoginContract.View {
    private var _binding: ScreenLoginBinding? = null
    private lateinit var presenter: LoginPresenter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ScreenLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = LoginPresenter(this)
        init()
    }

    private fun init() {
        binding.btnContinue.setOnClickListener {
            presenter.loginClicked(binding.phone.text.toString())
        }
        binding.tvCreateAccount.setOnClickListener { presenter.registerClicked() }
    }

    override fun openRegisterView() {
        findNavController().navigate(LoginScreenDirections.actionLoginScreenToRegisterScreen())
    }

    override fun enterAccount(userEntity: UserEntity) {
        findNavController().navigate(LoginScreenDirections.actionLoginScreenToVerifyScreen())
    }


    override fun setErrorToEditView(error: String) {
        binding.phone.error = error
    }
}