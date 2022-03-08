package kz.noxiq.chocoexpress.ui.home.menu.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.noxiq.chocoexpress.databinding.ViewHolderProductCategoryBinding
import kz.noxiq.chocoexpress.domain.menu.model.ProductCategory

class ProductCategoryAdapter: ListAdapter<ProductCategory, ProductCategoryViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCategoryViewHolder {
        val binding =
            ViewHolderProductCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProductCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductCategoryViewHolder, position: Int) {
        holder.onBind(getItem(position))
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