package uz.gita.shoppingappwithgithub.screens.register

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.gita.shoppingappwithgithub.databinding.ScreenRegisterBinding
import java.util.Calendar

class RegisterScreen : Fragment(), RegisterContract.View {
    private lateinit var presenter: RegisterContract.Presenter
    private var _binding: ScreenRegisterBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ScreenRegisterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = RegisterPresenter(this)
        init()
    }

    private fun init() {
        binding.btnContinue.setOnClickListener {
            presenter.clickedRegister(
                binding.firstName.text.toString(),
                binding.lastName.text.toString(),
                binding.phone.text.toString(),
                binding.etBirthdate.text.toString()
            )
        }
        binding.tvLogin.setOnClickListener { presenter.clickedHaveAccount() }
        binding.etBirthdate.setOnClickListener {
            showDatePickerDialog(
                binding.etBirthdate,
                requireContext()
            )

        }
    }

    private fun showDatePickerDialog(editText: EditText, context: Context) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(
            context,
            { _, selectedYear, selectedMonth, selectedDay ->
                val formattedDate = "${selectedDay}-${selectedMonth + 1}-$selectedYear"
                editText.setText(formattedDate)
            },
            year,
            month,
            day
        )

        datePickerDialog.datePicker.maxDate = calendar.timeInMillis

        datePickerDialog.show()
    }

    override fun openLogin() {
        findNavController().navigate(RegisterScreenDirections.actionRegisterScreenToLoginScreen())
    }

    override fun setErrorFirstNameEditText(error: String) {
        binding.firstName.error = error
    }

    override fun setErrorLastNameEditText(error: String) {
        binding.lastName.error = error
    }

    override fun setErrorPhoneEditText(error: String) {
        binding.phone.error = error
    }

    override fun setErrorBirthDayEditText(error: String) {
        binding.etBirthdate.error = error
    }
}