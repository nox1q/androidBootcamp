package kz.noxiq.chocoexpress.ui.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import kz.noxiq.chocoexpress.R
import kz.noxiq.chocoexpress.databinding.FragmentRahmetBinding
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