package kz.noxiq.chocoexpress.ui.home.menu.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.noxiq.chocoexpress.databinding.ViewHolderProductBinding
import kz.noxiq.chocoexpress.databinding.ViewHolderRestaurantBinding
import kz.noxiq.chocoexpress.domain.menu.model.Product
import kz.noxiq.chocoexpress.domain.restaurant.Restaurant
import kz.noxiq.chocoexpress.ui.home.RestaurantViewHolder

class ProductAdapter() : ListAdapter<Product, ProductViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            ViewHolderProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
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