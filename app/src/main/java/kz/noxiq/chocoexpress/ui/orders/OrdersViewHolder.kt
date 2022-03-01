package kz.noxiq.chocoexpress.ui.orders

import androidx.recyclerview.widget.RecyclerView
import kz.noxiq.chocoexpress.databinding.ViewHolderOrderBinding
import kz.noxiq.chocoexpress.domain.Order

class OrdersViewHolder(
    private val binding: ViewHolderOrderBinding,
    private val onOrderClicked: (Long) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(orders: Order) {
        with(binding) {
            tvOrderRestaurantName.text = orders.restaurantName
            tvOrderSum.text = orders.sum.toString()

            root.setOnClickListener {
                onOrderClicked(orders.id)
            }
        }
    }
}