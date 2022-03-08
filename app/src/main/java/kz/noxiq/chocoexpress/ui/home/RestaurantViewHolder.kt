package kz.noxiq.chocoexpress.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.noxiq.chocoexpress.databinding.ViewHolderRestaurantBinding
import kz.noxiq.chocoexpress.domain.restaurant.Restaurant

class RestaurantViewHolder(
    private val binding: ViewHolderRestaurantBinding,
    private val onRestaurantClicked: (Long) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(restaurant: Restaurant) {
        with(binding) {
            tvRestaurantName.text = restaurant.name
            tvRestaurantAddress.text = restaurant.address
            Glide.with(binding.root)
                .load(restaurant.imageUrl)
                .into(ivRestaurantPhoto)

            root.setOnClickListener {
                onRestaurantClicked(restaurant.id)
            }
        }
    }
}