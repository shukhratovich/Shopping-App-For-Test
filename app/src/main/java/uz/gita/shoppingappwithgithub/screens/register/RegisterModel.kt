package uz.gita.shoppingappwithgithub.screens.register

import uz.gita.shoppingappwithgithub.source.AppDatabase
import uz.gita.shoppingappwithgithub.source.entity.UserEntity

class RegisterModel : RegisterContract.Model {
    private val appDatabase = AppDatabase.instance
    override fun saveUser(user: UserEntity): Long {
        return appDatabase.getUserDao().addUser(user)
    }

}