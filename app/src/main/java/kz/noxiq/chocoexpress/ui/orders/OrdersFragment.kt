package kz.noxiq.chocoexpress.ui.orders

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_menu.*
import kz.noxiq.chocoexpress.R
import kz.noxiq.chocoexpress.databinding.FragmentOrdersBinding
import kz.noxiq.chocoexpress.domain.orders.Order
import kz.noxiq.chocoexpress.ui.orders.adapter.OrderAdapter
import kz.noxiq.chocoexpress.ui.utils.setVisibility
import javax.inject.Inject

class OrdersFragment : DaggerFragment(R.layout.fragment_orders) {

    private lateinit var binding: FragmentOrdersBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by navGraphViewModels<OrdersViewModel>(R.id.navigation_orders) { viewModelFactory }

    private val orderAdapter: OrderAdapter by lazy {
        OrderAdapter(::onOrderClicked)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOrdersBinding.bind(view)
        binding.rvOrders.adapter = orderAdapter
        viewModel.onStart()
        observeViewModel()
        setupListeners()
        setupToolbar()
    }

    private fun setupListeners() {
        with(binding) {
            buttonRegister.setOnClickListener {
                navigateToRegistration()
            }
        }
    }

    private fun navigateToRegistration() {
        findNavController().navigate(
            OrdersFragmentDirections.actionOrdersFragmentToRegistration()
        )

    }

    private fun observeViewModel() {
        viewModel.getIsLoggedLiveData().observe(viewLifecycleOwner, ::handleIsLogged)
        viewModel.getOrdersLiveData().observe(viewLifecycleOwner, orderAdapter::submitList)
    }

    private fun handleIsLogged(isLogged: Boolean) {
        binding.clAuthorize.setVisibility(!isLogged)
        binding.rvOrders.setVisibility(isLogged)
    }

    private fun navigateToOrderDetails() {
        findNavController().navigate(
            OrdersFragmentDirections.actionOrdersFragmentToOrderDetailsFragment()
        )
    }

    private fun onOrderClicked(order: Order) {
        viewModel.onOrderClicked(order)
        navigateToOrderDetails()
    }

    private fun setupToolbar() {
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

}