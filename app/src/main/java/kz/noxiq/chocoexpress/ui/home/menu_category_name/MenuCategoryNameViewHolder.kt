package kz.noxiq.chocoexpress.ui.home.menu_category_name

import androidx.recyclerview.widget.RecyclerView
import kz.noxiq.chocoexpress.databinding.ViewHolderCategoryNameBinding
import kz.noxiq.chocoexpress.databinding.ViewHolderMenuCategoryNameBinding
import kz.noxiq.chocoexpress.domain.menu.model.ProductCategory

class MenuCategoryNameViewHolder(private val binding: ViewHolderMenuCategoryNameBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(productCategory: ProductCategory) {
        with(binding) {
            tvProductCategoryName.text = productCategory.name
            tvProductCategoryCount.text = productCategory.products.size.toString()
        }
    }
}