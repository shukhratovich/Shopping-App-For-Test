package uz.gita.shoppingappwithgithub.screens.login

class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter {
    private val model = LoginModel()
    override fun registerClicked() {
        view.openRegisterView()
    }

    override fun loginClicked(phone: String) {
        if (phone.length == 9) {
            val user = model.getUser(phone)
            if (user != null) {
                view.enterAccount(user)
            } else {
                view.setErrorToEditView("Bunday raqamli foydalanuvchi mavjud emas!")
            }
        } else {
            view.setErrorToEditView("Raqam kiritilishida qandaydur xatolik bor!")
        }
    }
}