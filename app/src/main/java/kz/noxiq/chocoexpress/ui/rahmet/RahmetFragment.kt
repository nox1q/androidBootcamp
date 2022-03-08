package kz.noxiq.chocoexpress.ui.rahmet

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import dagger.android.support.DaggerFragment
import kz.noxiq.chocoexpress.R
import kz.noxiq.chocoexpress.databinding.FragmentMenuBinding
import kz.noxiq.chocoexpress.databinding.FragmentRahmetBinding
import kz.noxiq.chocoexpress.ui.home.menu.MenuFragmentArgs
import kz.noxiq.chocoexpress.ui.home.menu.MenuViewModel
import javax.inject.Inject

class RahmetFragment : DaggerFragment(R.layout.fragment_rahmet) {

    private lateinit var binding: FragmentRahmetBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: RahmetViewModel by viewModels {
        viewModelFactory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRahmetBinding.bind(view)
    }
}