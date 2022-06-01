package kz.noxiq.chocoexpress.ui.home.menu.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.noxiq.chocoexpress.databinding.ViewHolderProductCategoryBinding
import kz.noxiq.chocoexpress.domain.menu.model.ProductCategory
import kz.noxiq.chocoexpress.domain.menu.model.ProductCountUpdate

class ProductCategoryAdapter(
    private val onProductCountChangeClicked: (ProductCountUpdate) -> Unit
): ListAdapter<ProductCategory, ProductCategoryViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCategoryViewHolder {
        val binding =
            ViewHolderProductCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProductCategoryViewHolder(binding, onProductCountChangeClicked)
    }

    override fun onBindViewHolder(holder: ProductCategoryViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onBindViewHolder(
        holder: ProductCategoryViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)

            return
        }

        for (payload in payloads) {
            if (payload is ProductCountUpdate) {
                holder.bindProductCountUpdate(payload)
            }
        }
    }
}

private object DiffUtilCallback : DiffUtil.ItemCallback<ProductCategory>() {

    override fun areItemsTheSame(oldItem: ProductCategory, newItem: ProductCategory): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProductCategory, newItem: ProductCategory): Boolean {
        return oldItem == newItem
    }
}