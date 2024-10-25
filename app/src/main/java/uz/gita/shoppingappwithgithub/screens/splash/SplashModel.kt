package uz.gita.shoppingappwithgithub.screens.splash

import uz.gita.shoppingappwithgithub.source.MyPref

class SplashModel : SplashContract.Model {
    override fun getUserPhone(): String {
        return MyPref.isUserVerified()
    }

    override fun getStateVisitor(): Boolean {
        return MyPref.isUserFirstVisit()
    }
}