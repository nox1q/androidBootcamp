package kz.noxiq.chocoexpress.ui.home.menu_category_name

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import kz.noxiq.chocoexpress.databinding.ViewHolderMenuCategoryNameBinding
import kz.noxiq.chocoexpress.databinding.ViewHolderProductCategoryBinding
import kz.noxiq.chocoexpress.domain.menu.model.ProductCategory
import kz.noxiq.chocoexpress.ui.home.menu.category.ProductCategoryViewHolder

class MenuCategoryNameAdapter(): ListAdapter<ProductCategory, MenuCategoryNameViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuCategoryNameViewHolder {
        val binding =
            ViewHolderMenuCategoryNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MenuCategoryNameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuCategoryNameViewHolder, position: Int) {
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