package kz.noxiq.chocoexpress.ui.home.menu.product

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.noxiq.chocoexpress.databinding.ViewHolderProductBinding
import kz.noxiq.chocoexpress.domain.menu.model.Product

class ProductViewHolder(private val binding: ViewHolderProductBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(product: Product) {
        with(binding) {
            tvProductName.text = product.name
            tvProductDescription.text = product.description
            tvProductPrice.text = product.price.toString()
            Glide.with(root)
                .load(product.imageUrl)
                .into(ivProductImage)
        }
    }
}