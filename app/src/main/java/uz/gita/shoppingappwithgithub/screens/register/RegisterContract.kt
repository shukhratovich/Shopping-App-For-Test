package uz.gita.shoppingappwithgithub.screens.register

import uz.gita.shoppingappwithgithub.source.entity.UserEntity

interface RegisterContract {
    interface Model {
        fun saveUser(user: UserEntity): Long
    }

    interface Presenter {
        fun clickedRegister(firstName: String, lastName: String, phone: String, birthDate: String)
        fun clickedHaveAccount()
    }

    interface View {
        fun openLogin()
        fun setErrorFirstNameEditText(error: String)
        fun setErrorLastNameEditText(error: String)
        fun setErrorPhoneEditText(error: String)
        fun setErrorBirthDayEditText(error: String)
    }
}