package kz.noxiq.chocoexpress.ui.orders.order_details

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_menu.*
import kz.noxiq.chocoexpress.R
import kz.noxiq.chocoexpress.databinding.FragmentOrderDetailsBinding
import kz.noxiq.chocoexpress.databinding.FragmentOrdersBinding
import kz.noxiq.chocoexpress.domain.orders.Order
import kz.noxiq.chocoexpress.ui.orders.OrdersFragmentDirections
import kz.noxiq.chocoexpress.ui.orders.OrdersViewModel
import kz.noxiq.chocoexpress.ui.orders.adapter.OrderAdapter
import kz.noxiq.chocoexpress.ui.utils.formatDate
import kz.noxiq.chocoexpress.ui.utils.formatPrice
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class OrderDetailsFragment : DaggerFragment(R.layout.fragment_order_details) {

    private lateinit var binding: FragmentOrderDetailsBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by navGraphViewModels<OrdersViewModel>(R.id.navigation_orders) { viewModelFactory }

    private val shortProductAdapter: ShortProductAdapter by lazy {
        ShortProductAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOrderDetailsBinding.bind(view)
        binding.rvProducts.adapter = shortProductAdapter
        observeViewModel()
        setupToolbar()
    }

    private fun handleOrder(order: Order){
        with(binding){
            tvRestaurantName.text = order.restaurant.name
            tvRestaurantAddress.text = order.restaurant.address
            when(order.orderStatus){
                0 -> {
                    tvOrderStatus.text = " В обработке"
                    tvOrderStatus.setTextColor(Color.parseColor("#2997FF"))
                }
                1 -> {
                    tvOrderStatus.text = " На кухне"
                    tvOrderStatus.setTextColor(Color.parseColor("#E4853D"))
                }
                2 -> {
                    tvOrderStatus.text = " Готов"
                    tvOrderStatus.setTextColor(Color.parseColor("#51A451"))
                }
                3 -> {
                    tvOrderStatus.text = " Завершен"
                    tvOrderStatus.setTextColor(Color.parseColor("#8F8F8F"))
                }
            }
            tvOrderDate.text = formatDate(order.createdAt)
            tvOrderNumber.text = "#${order.id}"
            tvTotalPrice.text = formatPrice(order.totalPrice)

        }
    }

    private fun observeViewModel() {
        viewModel.getOrderLiveData().observe(viewLifecycleOwner,::handleOrder)
        viewModel.getProductsLiveData().observe(viewLifecycleOwner,shortProductAdapter::submitList)
    }

    private fun setupToolbar() {
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}