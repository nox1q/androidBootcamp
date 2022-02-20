package kz.noxiq.chocoexpress.ui.home

import androidx.recyclerview.widget.RecyclerView
import kz.noxiq.chocoexpress.databinding.ViewHolderRestaurantBinding
import kz.noxiq.chocoexpress.domain.Restaurant

class RestaurantViewHolder(
    private val binding: ViewHolderRestaurantBinding,
    private val onRestaurantClicked: (Long) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(restaurant: Restaurant) {
        with(binding) {
            tvRestaurantName.text = restaurant.name
            tvRestaurantAddress.text = restaurant.address

            root.setOnClickListener {
                onRestaurantClicked(restaurant.id)
            }
        }
    }
}