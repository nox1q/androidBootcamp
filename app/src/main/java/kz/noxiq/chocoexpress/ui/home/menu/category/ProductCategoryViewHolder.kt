package kz.noxiq.chocoexpress.ui.home.menu.category

import androidx.recyclerview.widget.RecyclerView
import kz.noxiq.chocoexpress.databinding.ViewHolderProductCategoryBinding
import kz.noxiq.chocoexpress.domain.menu.model.ProductCategory
import kz.noxiq.chocoexpress.ui.home.menu.product.ProductAdapter

class ProductCategoryViewHolder(private val binding: ViewHolderProductCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(productCategory: ProductCategory) {
        with(binding) {
            tvProductCategoryName.text = productCategory.name
            rvProducts.adapter = ProductAdapter().apply {
                submitList(productCategory.products)
            }
        }
    }
}