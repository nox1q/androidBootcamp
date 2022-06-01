package kz.noxiq.chocoexpress.ui.home.stash

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_menu.*
import kz.noxiq.chocoexpress.R
import kz.noxiq.chocoexpress.databinding.FragmentStashBinding
import kz.noxiq.chocoexpress.domain.menu.model.Menu
import kz.noxiq.chocoexpress.domain.menu.model.OrderCreate
import kz.noxiq.chocoexpress.ui.home.menu.MenuViewModel
import kz.noxiq.chocoexpress.ui.home.menu.category.ProductCategoryAdapter
import kz.noxiq.chocoexpress.ui.utils.formatPrice
import kz.noxiq.chocoexpress.ui.utils.observeEvent
import javax.inject.Inject

class StashFragment : DaggerFragment(R.layout.fragment_stash) {

    private lateinit var binding: FragmentStashBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by navGraphViewModels<MenuViewModel>(R.id.menu) { viewModelFactory }

    private val stashOrderAdapter: StashOrderAdapter by lazy {
        StashOrderAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentStashBinding.bind(view)
        binding.rvOrder.adapter = stashOrderAdapter
        setupToolbar()
        observeViewModel()
        setupListeners()

    }

    private fun observeViewModel() {
        viewModel.getMenuLiveData().observe(
            viewLifecycleOwner, ::handleMenu
        )
        viewModel.getOrderCreateLiveData().observe(
            viewLifecycleOwner, ::handleOrderCreate
        )
        viewModel.getCloseLiveData().observeEvent(
            viewLifecycleOwner, { findNavController().popBackStack() })
    }

    private fun setupListeners() {
        binding.btnPay.setOnClickListener {
            viewModel.onPayClicked()
        }
    }

    private fun handleOrderCreate(orderCreate: OrderCreate) {
        stashOrderAdapter.submitList(orderCreate.products)
        val totalPrice: String = formatPrice(orderCreate.totalPrice)
        binding.tvTotalPrice.text = totalPrice
        binding.btnTotalPrice.text = totalPrice
    }

    private fun handleMenu(menu: Menu) {
        binding.tvRestaurantName.text = menu.restaurantName
        binding.tvRestaurantAddress.text = menu.restaurantLocation
    }

    private fun setupToolbar() {
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

}
