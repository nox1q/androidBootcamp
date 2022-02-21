package kz.noxiq.chocoexpress.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import kz.noxiq.chocoexpress.R
import kz.noxiq.chocoexpress.databinding.FragmentHomeBinding
import kz.noxiq.chocoexpress.observe
import javax.inject.Inject

class HomeFragment : DaggerFragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: HomeViewModel by viewModels {
        viewModelFactory
    }

    private val restaurantAdapter: RestaurantAdapter by lazy {
        RestaurantAdapter(::navigateToRestaurantMenu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)
        bindAdapter()
        observeViewModel()
    }

    private fun observeViewModel() {

        viewModel.getRestaurantsLiveData().observe(
            viewLifecycleOwner,restaurantAdapter::submitList)
    }

    private fun bindAdapter() {
        binding.recyclerView.adapter = restaurantAdapter
    }

    private fun navigateToRestaurantMenu(restaurantId: Long) {
        // логика findNavController
        Log.d("test", "test")
    }
}