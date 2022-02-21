package kz.noxiq.chocoexpress.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import kz.noxiq.chocoexpress.R
import kz.noxiq.chocoexpress.databinding.FragmentHomeBinding
import kz.noxiq.chocoexpress.ui.utils.getDividerItemDecoration
import kz.noxiq.chocoexpress.ui.utils.observe
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
            viewLifecycleOwner, restaurantAdapter::submitList
        )
    }

    private fun bindAdapter() {
        binding.recyclerView.adapter = restaurantAdapter
        binding.recyclerView.addItemDecoration(
            getDividerItemDecoration(
                context = requireContext(),
                R.dimen.dp_16,
                R.dimen.dp_0,
                R.dimen.dp_16,
                R.dimen.dp_0
            )
        )
    }

    private fun navigateToRestaurantMenu(restaurantId: Long) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToMenuFragment(restaurantId)
        )
        Log.d("test", "test")
    }
}