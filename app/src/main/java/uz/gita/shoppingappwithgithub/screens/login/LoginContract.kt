package uz.gita.shoppingappwithgithub.screens.login

import uz.gita.shoppingappwithgithub.source.entity.UserEntity

interface LoginContract {
    interface Model {
        fun getUser(phone: String): UserEntity?
    }

    interface Presenter {
        fun registerClicked()
        fun loginClicked(phone: String)
    }

    interface View {
        fun openRegisterView()
        fun enterAccount(userEntity: UserEntity)
        fun setErrorToEditView(error: String)
    }
}