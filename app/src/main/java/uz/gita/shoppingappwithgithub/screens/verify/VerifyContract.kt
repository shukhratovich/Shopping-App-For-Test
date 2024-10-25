package uz.gita.shoppingappwithgithub.screens.verify

interface VerifyContract {
    interface Model {
        fun saveUserToPreference(phone: String)
    }

    interface Presenter {
        fun verifyClicked(code: String,phone: String)
        fun resentCodeClicked()
        fun btnHomeClicked(phone: String)
    }

    interface View {
        fun showSmsCode(code: String)
        fun openHomeScreen(phone:String)
        fun codeVerified()
        fun setErrorCode(error:String)
    }
}