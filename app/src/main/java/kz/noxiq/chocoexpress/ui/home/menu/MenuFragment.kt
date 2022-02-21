package kz.noxiq.chocoexpress.ui.home.menu

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import kz.noxiq.chocoexpress.R
import kz.noxiq.chocoexpress.databinding.FragmentMenuBinding
import javax.inject.Inject

class MenuFragment : DaggerFragment(R.layout.fragment_menu) {

    private lateinit var menuFragmentHomeBinding: FragmentMenuBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MenuViewModel by viewModels {
        viewModelFactory
    }
}