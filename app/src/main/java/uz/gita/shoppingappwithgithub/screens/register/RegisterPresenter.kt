package uz.gita.shoppingappwithgithub.screens.register

import android.util.Log
import uz.gita.shoppingappwithgithub.source.entity.UserEntity

class RegisterPresenter(private val view: RegisterContract.View) : RegisterContract.Presenter {
    private val model = RegisterModel()
    override fun clickedRegister(
        firstName: String,
        lastName: String,
        phone: String,
        birthDate: String
    ) {
        if (lastName.isBlank() && firstName.isBlank() && phone.isBlank() && birthDate.isBlank()) {
            Log.d("TTT", "clickedRegister: $firstName")
            view.setErrorFirstNameEditText("Maydonni to`ldiring!")
            view.setErrorLastNameEditText("Maydonni to`ldiring!")
            view.setErrorPhoneEditText("Maydonni to`ldiring!")
            view.setErrorBirthDayEditText("Maydonni to`ldiring!")
        } else {
            if (firstName.isBlank()) view.setErrorFirstNameEditText("Maydonni to`ldiring")
            if (lastName.isBlank()) view.setErrorLastNameEditText("Maydonni to`ldiring")
            if (phone.isBlank()) view.setErrorPhoneEditText("Maydonni to`ldiring")
            if (birthDate.isBlank()) view.setErrorBirthDayEditText("Maydonni to`ldiring")

            if (lastName.isNotBlank() && firstName.isNotBlank() && phone.isNotBlank() && birthDate.isNotBlank()) {
                if (phone.length != 9) {
                    view.setErrorPhoneEditText("Raqam noto`g`ri kiritilgan")
                } else {
                    val added = model.saveUser(UserEntity(0, firstName, lastName, birthDate, phone))
                    if (added == -1L) {
                        view.setErrorPhoneEditText("Bunday raqam ro`yxatdan o`tgan!")
                    } else {
                        view.openLogin()
                    }
                }
            }

        }


    }

    override fun clickedHaveAccount() {
        view.openLogin()
    }
}