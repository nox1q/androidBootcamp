package kz.noxiq.chocoexpress.ui.home.menu.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.noxiq.chocoexpress.databinding.ViewHolderProductBinding
import kz.noxiq.chocoexpress.databinding.ViewHolderRestaurantBinding
import kz.noxiq.chocoexpress.domain.menu.model.Product
import kz.noxiq.chocoexpress.domain.menu.model.ProductCountUpdate
import kz.noxiq.chocoexpress.domain.restaurant.Restaurant
import kz.noxiq.chocoexpress.ui.home.RestaurantViewHolder

const val KEY_PRODUCT_COUNT = "key_product_count"

class ProductAdapter(
    private val onProductCountChangeClicked: (Int, Boolean) -> Unit
) : ListAdapter<Product, ProductViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            ViewHolderProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProductViewHolder(binding, onProductCountChangeClicked)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)

            return
        }

        for (payload in payloads) {
            if (payload is Bundle) {
                val count: Int = payload.getInt(KEY_PRODUCT_COUNT)
                holder.bindCount(count)
            }
        }
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