package uz.gita.shoppingappwithgithub.screens.verify

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.gita.shoppingappwithgithub.databinding.ScreenVerifyBinding

class VerifyScreen : Fragment(), VerifyContract.View {
    private lateinit var presenter: VerifyContract.Presenter
    private var _binding: ScreenVerifyBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ScreenVerifyBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = VerifyPresenter(this)
        init()
    }

    private fun init() {
        binding.btnContinue.setOnClickListener {
            presenter.verifyClicked(binding.code.text.toString())
        }
        binding.btnHome.setOnClickListener {
            presenter.btnHomeClicked()
        }
        binding.tvResent.setOnClickListener { presenter.resentCodeClicked() }
        presenter.resentCodeClicked()
    }

    override fun showSmsCode(code: String) {
        Toast.makeText(requireContext(), "sms kodingiz : $code", Toast.LENGTH_LONG).show()
    }

    override fun openHomeScreen() {
        findNavController().navigate(VerifyScreenDirections.actionVerifyScreenToHomeScreen())
    }

    override fun codeVerified() {
        Log.d("TTT", "codeVerified: visibility done")
        binding.code.visibility = View.INVISIBLE
        binding.tvResent.visibility = View.INVISIBLE
        binding.tiLayout.visibility = View.INVISIBLE
        binding.messageIcon.visibility = View.INVISIBLE
        binding.successIcon.visibility = View.VISIBLE
        binding.btnContinue.visibility = View.INVISIBLE
        binding.btnHome.visibility = View.VISIBLE
    }

    override fun setErrorCode(error: String) {
        binding.code.error = error
    }
}