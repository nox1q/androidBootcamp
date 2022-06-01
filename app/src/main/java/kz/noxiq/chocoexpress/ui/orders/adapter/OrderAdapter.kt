package kz.noxiq.chocoexpress.ui.orders.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.noxiq.chocoexpress.databinding.ViewHolderOrderStatusBinding
import kz.noxiq.chocoexpress.domain.orders.Order

class OrderAdapter(
    private val onOrderClicked: (Order) -> Unit
) : ListAdapter<Order, OrderViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding =
            ViewHolderOrderStatusBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return OrderViewHolder(binding, onOrderClicked)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
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