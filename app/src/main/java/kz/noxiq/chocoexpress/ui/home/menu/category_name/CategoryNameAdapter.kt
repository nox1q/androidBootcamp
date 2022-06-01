package kz.noxiq.chocoexpress.ui.home.menu.category_name

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.noxiq.chocoexpress.databinding.ViewHolderCategoryNameBinding
import kz.noxiq.chocoexpress.domain.menu.model.ProductCategory
import kz.noxiq.chocoexpress.ui.home.menu.category.ProductCategoryViewHolder

class CategoryNameAdapter(
    private val onCategoryClicked: (Int) -> Unit
) : ListAdapter<String, CategoryNameViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryNameViewHolder {
        val binding =
            ViewHolderCategoryNameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        return CategoryNameViewHolder(binding, onCategoryClicked)
    }

    override fun onBindViewHolder(holder: CategoryNameViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

private object DiffUtilCallback : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}