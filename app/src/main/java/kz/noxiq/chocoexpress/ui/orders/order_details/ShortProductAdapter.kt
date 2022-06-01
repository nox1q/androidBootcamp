package kz.noxiq.chocoexpress.ui.orders.order_details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.noxiq.chocoexpress.databinding.ViewHolderOrderDetailBinding
import kz.noxiq.chocoexpress.databinding.ViewHolderOrderStatusBinding
import kz.noxiq.chocoexpress.domain.menu.model.Product
import kz.noxiq.chocoexpress.domain.orders.Order
import kz.noxiq.chocoexpress.ui.orders.adapter.OrderViewHolder

class ShortProductAdapter: ListAdapter<Product, ShortProductViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShortProductViewHolder {
        val binding =
            ViewHolderOrderDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ShortProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShortProductViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

private object DiffUtilCallback : DiffUtil.ItemCallback<Product>() {

    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}