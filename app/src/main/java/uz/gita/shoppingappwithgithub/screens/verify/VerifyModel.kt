package uz.gita.shoppingappwithgithub.screens.verify

import uz.gita.shoppingappwithgithub.source.MyPref

class VerifyModel : VerifyContract.Model {
    override fun saveUserToPreference(phone: String) {
        MyPref.userVerified(phone)
    }
}