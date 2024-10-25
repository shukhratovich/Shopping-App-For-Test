package uz.gita.shoppingappwithgithub.screens.verify

interface VerifyContract {
    interface Model {
        fun saveUserToPreference(phone: String)
    }

    interface Presenter {
        fun verifyClicked(code: String)
        fun resentCodeClicked()
        fun btnHomeClicked()
    }

    interface View {
        fun showSmsCode(code: String)
        fun openHomeScreen()
        fun codeVerified()
        fun setErrorCode(error:String)
    }
}