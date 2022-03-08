package kz.noxiq.chocoexpress.ui.orders.order_details

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_menu.*
import kz.noxiq.chocoexpress.R
import kz.noxiq.chocoexpress.databinding.FragmentOrderDetailsBinding
import kz.noxiq.chocoexpress.databinding.FragmentOrdersBinding
import kz.noxiq.chocoexpress.ui.orders.OrdersFragmentDirections
import kz.noxiq.chocoexpress.ui.orders.OrdersViewModel
import javax.inject.Inject

class OrderDetailsFragment : DaggerFragment(R.layout.fragment_order_details) {

    private lateinit var binding: FragmentOrderDetailsBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by navGraphViewModels<OrdersViewModel>(R.id.navigation_orders) { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOrderDetailsBinding.bind(view)
        observeViewModel()
        setupToolbar()

    }

    private fun observeViewModel() {

    }

    private fun setupToolbar() {
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}