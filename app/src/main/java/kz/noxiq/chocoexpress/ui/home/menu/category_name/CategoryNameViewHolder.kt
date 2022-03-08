package kz.noxiq.chocoexpress.ui.home.menu.category_name

import androidx.recyclerview.widget.RecyclerView
import kz.noxiq.chocoexpress.databinding.ViewHolderCategoryNameBinding
import kz.noxiq.chocoexpress.databinding.ViewHolderRestaurantImageBinding

class CategoryNameViewHolder(
    private val binding: ViewHolderCategoryNameBinding,
    private val onCategoryClicked: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(productCategoryName: String) {
        binding.tvProductCategoryName.text = productCategoryName
    }
}