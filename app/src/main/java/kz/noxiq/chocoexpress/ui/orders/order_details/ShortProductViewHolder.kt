package kz.noxiq.chocoexpress.ui.orders.order_details

import androidx.recyclerview.widget.RecyclerView
import kz.noxiq.chocoexpress.databinding.ViewHolderOrderDetailBinding
import kz.noxiq.chocoexpress.domain.menu.model.Product
import kz.noxiq.chocoexpress.ui.utils.formatPrice

class ShortProductViewHolder(
    val binding: ViewHolderOrderDetailBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(product: Product){
        with(binding){
            var price = product.count * product.price
            tvProductName.text = "${product.count} x ${product.name}"
            tvPrice.text = formatPrice(price)
        }
    }
}