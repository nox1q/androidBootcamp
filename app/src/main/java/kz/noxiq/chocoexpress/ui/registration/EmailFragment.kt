package kz.noxiq.chocoexpress.ui.registration

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_menu.*
import kz.noxiq.chocoexpress.R
import kz.noxiq.chocoexpress.databinding.FragmentEmailBinding
import javax.inject.Inject

class EmailFragment : DaggerFragment(R.layout.fragment_email) {

    private lateinit var binding: FragmentEmailBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by navGraphViewModels<RegistrationViewModel>(R.id.login) { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentEmailBinding.bind(view)
        setupToolbar()
        navigateToPasswordFragment()
    }

    private fun navigateToPasswordFragment() {
        binding.buttonLogin.setOnClickListener {
            val navBuilder = NavOptions.Builder()
            navBuilder.setPopUpTo(R.id.loginFragment,true)
            findNavController().navigate(
                EmailFragmentDirections.actionEmailFragmentToPasswordFragment(binding.etEmail.text.toString()),
                navBuilder.build()
            )
        }
    }

    private fun setupToolbar() {
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}