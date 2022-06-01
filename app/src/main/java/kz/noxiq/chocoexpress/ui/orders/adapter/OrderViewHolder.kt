package kz.noxiq.chocoexpress.ui.orders.adapter

import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.core.content.res.TypedArrayUtils.getString
import androidx.recyclerview.widget.RecyclerView
import kz.noxiq.chocoexpress.R
import kz.noxiq.chocoexpress.databinding.ViewHolderOrderStatusBinding
import kz.noxiq.chocoexpress.domain.orders.Order
import kz.noxiq.chocoexpress.ui.utils.formatDate
import kz.noxiq.chocoexpress.ui.utils.formatPrice

class OrderViewHolder(
    private val binding: ViewHolderOrderStatusBinding,
    private val onOrderClicked: (Order) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(order: Order) {
        with(binding) {
            tvRestaurantName.text = order.restaurant.name
            tvTotalPrice.text = formatPrice(order.totalPrice)
            tvOrderTime.text = formatDate(order.createdAt)
            when(order.orderStatus){
                0 -> {
                    tvRestaurantStatus.text = " В обработке"
                    tvRestaurantStatus.setTextColor(Color.parseColor("#2997FF"))
                }
                1 -> {
                    tvRestaurantStatus.text = " На кухне"
                    tvRestaurantStatus.setTextColor(Color.parseColor("#E4853D"))
                }
                2 -> {
                tvRestaurantStatus.text = " Готов"
                tvRestaurantStatus.setTextColor(Color.parseColor("#51A451"))
                }
                3 -> {
                    tvRestaurantStatus.text = " Завершен"
                    tvRestaurantStatus.setTextColor(Color.parseColor("#8F8F8F"))
                }
            }
            root.setOnClickListener{
                onOrderClicked(order)
            }
        }
    }

}