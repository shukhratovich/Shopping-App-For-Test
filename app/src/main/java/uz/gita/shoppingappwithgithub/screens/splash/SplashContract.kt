package uz.gita.shoppingappwithgithub.screens.splash

interface SplashContract {
    interface Model {
        fun getUserPhone(): String
        fun getStateVisitor(): Boolean
    }

    interface Presenter {
        fun timerOut()
    }

    interface View {
        fun navigateToHome(phone: String)
        fun navigateToLogin()
        fun navigateToMainPager()
    }
}