package kz.noxiq.chocoexpress.ui.home.menu.product

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.noxiq.chocoexpress.databinding.ViewHolderProductBinding
import kz.noxiq.chocoexpress.domain.menu.model.Product
import kz.noxiq.chocoexpress.ui.utils.formatPrice
import kz.noxiq.chocoexpress.ui.utils.setVisibility

class ProductViewHolder(
    private val binding: ViewHolderProductBinding,
    private val onProductCountChangeClicked: (Int, Boolean) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(product: Product) {
        with(binding) {
            tvProductName.text = product.name
            tvProductDescription.text = product.description
            tvProductPrice.text = formatPrice(product.price)
            bindCount(product.count)

            Glide.with(root)
                .load(product.imageUrl)
                .centerCrop()
                .into(ivProductImage)

            tvAdd.setOnClickListener {
                onProductCountChangeClicked(adapterPosition, true)
            }
            tvRemove.setOnClickListener {
                onProductCountChangeClicked(adapterPosition, false)
            }
        }
    }

    fun bindCount(count: Int) {
        val isCountHigherThanZero: Boolean = count > 0

        with(binding) {
            tvCount.setVisibility(isCountHigherThanZero)
            tvRemove.setVisibility(isCountHigherThanZero)

            tvCount.text = count.toString()
        }
    }
}