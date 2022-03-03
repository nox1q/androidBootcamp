package kz.noxiq.chocoexpress.ui.orders

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import kz.noxiq.chocoexpress.R
import kz.noxiq.chocoexpress.databinding.FragmentHomeBinding
import kz.noxiq.chocoexpress.databinding.FragmentOrdersBinding
import kz.noxiq.chocoexpress.observe
import kz.noxiq.chocoexpress.ui.home.HomeViewModel
import kz.noxiq.chocoexpress.ui.home.RestaurantAdapter
import javax.inject.Inject

class OrdersFragment : DaggerFragment(R.layout.fragment_orders) {
    private lateinit var binding: FragmentOrdersBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: OrdersViewModel by viewModels {
        viewModelFactory
    }

    private val ordersAdapter: OrdersAdapter by lazy {
        OrdersAdapter(::navigateToOrderDetails)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentOrdersBinding.bind(view)
        bindAdapter()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.getOrdersLiveData().observe(
            viewLifecycleOwner, ordersAdapter::submitList)
    }

    private fun bindAdapter() {
        binding.rvOrders.adapter = ordersAdapter
    }

    private fun navigateToOrderDetails(orderId: Long) {
        // логика findNavController
        Log.d("test", "Orders test")
    }
}