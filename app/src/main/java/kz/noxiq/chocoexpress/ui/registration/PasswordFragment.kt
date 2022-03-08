package kz.noxiq.chocoexpress.ui.registration

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_menu.*
import kz.noxiq.chocoexpress.R
import kz.noxiq.chocoexpress.databinding.FragmentPasswordBinding
import javax.inject.Inject

class PasswordFragment : DaggerFragment(R.layout.fragment_password) {

    private lateinit var binding: FragmentPasswordBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by navGraphViewModels<RegistrationViewModel>(R.id.login) { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPasswordBinding.bind(view)
        setupToolbar()
    }

    private fun setupToolbar() {
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}