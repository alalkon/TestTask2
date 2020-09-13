package ru.alena.testtask2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import ru.alena.testtask2.databinding.FragmentSignBinding
import java.util.regex.Pattern


class SignFragment() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSignBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_sign,
            container, false
        )

        fun isPasswordValid(password: String): Boolean {
            val passwordREGEX = Pattern.compile(
                "^" +
                        "(?=.*[0-9])" +         //at least 1 digit
                        "(?=.*[a-z])" +         //at least 1 lower case letter
                        "(?=.*[A-Z])" +         //at least 1 upper case letter
                        "(?=.*[a-zA-Z])" +      //any letter
                        "(?=.*[!.,<>@#$%^&+=])" +    //at least 1 special character
                        "(?=\\S+$)" +           //no white spaces
                        ".{6,}" +               //at least 8 characters
                        "$"
            );
            return passwordREGEX.matcher(password).matches()
        }

        fun isEmailValid(email: String): Boolean {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        binding.emailSignUp.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.emailSignUp.text.isEmpty() || !isEmailValid(binding.emailSignUp.text.toString())) {
                    binding.emailSignUp.error = "Field shouldn't be blank and asd12@asd.com"
                }
            }
        })

        binding.passwordSignUp.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.passwordSignUp.text.isEmpty() || !isPasswordValid(binding.passwordSignUp.text.toString())) {
                    binding.passwordSignUp.error = "Field shouldn't be blank and password"
                }
            }
        })


        binding.goSignUpButton.setOnClickListener { view: View ->
            if (isEmailValid(binding.emailSignUp.text.toString()) && isPasswordValid(binding.passwordSignUp.text.toString())) {
                view.findNavController().navigate(R.id.action_signFragment_to_userPageFragment)
            }

        }
        return binding.root
    }
}

