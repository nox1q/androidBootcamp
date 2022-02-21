package kz.noxiq.chocoexpress.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.noxiq.chocoexpress.databinding.ViewHolderRestaurantBinding
import kz.noxiq.chocoexpress.domain.Restaurant
import kotlin.coroutines.coroutineContext

class RestaurantViewHolder(
    private val binding: ViewHolderRestaurantBinding,
    private val onRestaurantClicked: (Long) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(restaurant: Restaurant) {
        with(binding) {
            tvRestaurantName.text = restaurant.name
            tvRestaurantAddress.text = restaurant.address
            Glide.with(ivRestaurantPhoto.context)
                .load(restaurant.photoUrl)
                .into(ivRestaurantPhoto)

            root.setOnClickListener {
                onRestaurantClicked(restaurant.id)
            }
        }
    }
}