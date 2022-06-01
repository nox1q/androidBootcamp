package kz.noxiq.chocoexpress.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_menu.*
import kz.noxiq.chocoexpress.R
import kz.noxiq.chocoexpress.databinding.FragmentLoginBinding
import javax.inject.Inject

class LoginFragment : DaggerFragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: LoginViewModel by viewModels {
        viewModelFactory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLoginBinding.bind(view)
        setupToolbar()
        setupListeners()
    }

    private fun setupListeners() {
        with(binding) {
            tvCreateAccount.setOnClickListener {
                navigateToRegistration()
            }
            buttonSignIn.setOnClickListener {
                viewModel.onLoginClicked(
                    email = etEmail.text.toString(),
                    password = etPassword.text.toString()
                )
                findNavController().popBackStack()
            }
        }
    }

    private fun navigateToRegistration() {
        findNavController().navigate(
            LoginFragmentDirections.actionLoginFragmentToRegistration()
        )
    }

    private fun setupToolbar() {
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

}