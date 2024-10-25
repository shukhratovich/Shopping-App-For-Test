package uz.gita.shoppingappwithgithub.screens.login

import uz.gita.shoppingappwithgithub.source.AppDatabase
import uz.gita.shoppingappwithgithub.source.entity.UserEntity


class LoginModel : LoginContract.Model {
    private val appDatabase = AppDatabase.instance
    override fun getUser(phone: String): UserEntity? {
        return appDatabase.getUserDao().getUserByPhone(phone)
    }
}