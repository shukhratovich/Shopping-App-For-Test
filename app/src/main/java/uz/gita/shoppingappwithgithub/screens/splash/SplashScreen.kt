package uz.gita.shoppingappwithgithub.screens.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.gita.shoppingappwithgithub.R
import uz.gita.shoppingappwithgithub.source.MyPref

@SuppressLint("CustomSplashScreen")
class SplashScreen : Fragment(R.layout.screen_splash) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            if (MyPref.isUserFirstVisit()) {
                findNavController().navigate(SplashScreenDirections.actionSplashScreenToHomeScreen())
            } else {
                findNavController().navigate(SplashScreenDirections.actionSplashScreenToMainPager())
            }
        }, 3000)

//        Handler().postDelayed({
//            if (MyPref.isUserFirstVisit()) {
//                findNavController().navigate(SplashScreenDirections.actionSplashScreenToHomeScreen())
//            } else {
//                findNavController().navigate(SplashScreenDirections.actionSplashScreenToMainPager())
//            }
//        }, 3000)
    }
}