package uz.gita.shoppingappwithgithub.screens.verify

import kotlin.random.Random

class VerifyPresenter(private val view: VerifyContract.View) : VerifyContract.Presenter {
    private val model = VerifyModel()
    private var smsCode: String = generateSmsCode()


    override fun verifyClicked(code: String,phone: String) {
        if (code.isBlank()) {
            view.setErrorCode("Kodni to`g`ri kiriting!")
        } else if (code == smsCode) {
            view.codeVerified()
            model.saveUserToPreference(phone)
        }
    }

    override fun resentCodeClicked() {
        smsCode = generateSmsCode()
        view.showSmsCode(smsCode)
    }

    override fun btnHomeClicked(phone:String) {
        view.openHomeScreen(phone)
    }

    private fun generateSmsCode(): String {
        val code = Random.nextInt(1000, 10000)
        return code.toString()
    }
}