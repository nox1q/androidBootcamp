package kz.noxiq.chocoexpress.ui.home.stash

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.noxiq.chocoexpress.databinding.FragmentStashBinding
import kz.noxiq.chocoexpress.databinding.ViewHolderOrderBinding
import kz.noxiq.chocoexpress.domain.menu.model.Product
import kz.noxiq.chocoexpress.ui.utils.formatPrice

class StashOrderViewHolder(
    private val binding: ViewHolderOrderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(product: Product) {
        with(binding) {
            tvProductName.text = product.name
            tvProductPrice.text = formatPrice(product.price)
            tvCount.text = product.count.toString()

            Glide.with(root)
                .load(product.imageUrl)
                .centerCrop()
                .into(ivProductImage)
        }
    }
}