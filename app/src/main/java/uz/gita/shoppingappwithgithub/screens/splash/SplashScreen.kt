package uz.gita.shoppingappwithgithub.screens.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.gita.shoppingappwithgithub.R

@SuppressLint("CustomSplashScreen")
class SplashScreen : Fragment(R.layout.screen_splash), SplashContract.View {
    private lateinit var presenter: SplashContract.Presenter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = SplashPresenter(this)
        init()
    }

    private fun init() {
        Handler(Looper.getMainLooper()).postDelayed({
            presenter.timerOut()
        }, 3000)
    }

    override fun navigateToHome(phone: String) {
        findNavController().navigate(SplashScreenDirections.actionSplashScreenToHomeScreen(phone))
    }

    override fun navigateToLogin() {
        findNavController().navigate(SplashScreenDirections.actionSplashScreenToLoginScreen(""))
    }

    override fun navigateToMainPager() {
        findNavController().navigate(SplashScreenDirections.actionSplashScreenToMainPager())
    }
}