package kz.noxiq.chocoexpress.ui.orders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.noxiq.chocoexpress.databinding.ViewHolderOrderBinding
import kz.noxiq.chocoexpress.domain.Order
import kz.noxiq.chocoexpress.domain.Restaurant

class OrdersAdapter(
    private val onOrdersClicked: (Long) -> Unit
) : ListAdapter<Order, OrdersViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        val binding =
            ViewHolderOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return OrdersViewHolder(binding, onOrdersClicked)
    }

    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

private object DiffUtilCallback : DiffUtil.ItemCallback<Order>() {

    override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean {
        return oldItem == newItem
    }
}