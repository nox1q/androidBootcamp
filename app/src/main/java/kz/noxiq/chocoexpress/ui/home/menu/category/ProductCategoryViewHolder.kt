package kz.noxiq.chocoexpress.ui.home.menu.category

import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import kz.noxiq.chocoexpress.databinding.ViewHolderProductCategoryBinding
import kz.noxiq.chocoexpress.domain.menu.model.ProductCategory
import kz.noxiq.chocoexpress.domain.menu.model.ProductCountUpdate
import kz.noxiq.chocoexpress.ui.home.menu.product.KEY_PRODUCT_COUNT
import kz.noxiq.chocoexpress.ui.home.menu.product.ProductAdapter

class ProductCategoryViewHolder(
    private val binding: ViewHolderProductCategoryBinding,
    private val onProductCountChangeClicked: (ProductCountUpdate) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private val productAdapter: ProductAdapter by lazy {
        ProductAdapter(::onProductCountChangeClicked)
    }

    fun onBind(productCategory: ProductCategory) {
        with(binding) {
            tvProductCategoryName.text = productCategory.name
            rvProducts.adapter = productAdapter
            productAdapter.submitList(productCategory.products)
        }
    }

    fun bindProductCountUpdate(productCountUpdate: ProductCountUpdate) {
        productAdapter.notifyItemChanged(productCountUpdate.productPosition, bundleOf(KEY_PRODUCT_COUNT to productCountUpdate.count))
    }

    private fun onProductCountChangeClicked(productPosition: Int, isPlus: Boolean) {
        onProductCountChangeClicked(
            ProductCountUpdate(
                productCategoryPosition = adapterPosition,
                productPosition = productPosition,
                isPlus = isPlus
            )
        )
    }
}