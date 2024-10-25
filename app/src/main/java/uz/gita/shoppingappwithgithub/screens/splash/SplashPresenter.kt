package uz.gita.shoppingappwithgithub.screens.splash

class SplashPresenter(private val view: SplashContract.View) : SplashContract.Presenter {
    private val model = SplashModel()
    override fun timerOut() {
        val phone = model.getUserPhone()
        if (phone.length == 9) {
            view.navigateToHome(phone)
        } else if (model.getStateVisitor()) {
            view.navigateToLogin()
        } else {
            view.navigateToMainPager()
        }
    }
}