package kz.noxiq.chocoexpress.ui.orders.adapter

import androidx.recyclerview.widget.RecyclerView
import kz.noxiq.chocoexpress.databinding.ViewHolderOrderStatusBinding
import kz.noxiq.chocoexpress.domain.orders.Order

class OrderViewHolder(
    private val binding: ViewHolderOrderStatusBinding,
    private val onOrderClicked: (Order) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(order: Order) {
        with(binding) {
            tvRestaurantName.text = order.restaurant.name
            tvTotalPrice.text = order.totalPrice.toString()
            tvOrderTime.text = order.createdAt
            tvRestaurantStatus.text = order.orderStatus.toString()
        }
    }
}