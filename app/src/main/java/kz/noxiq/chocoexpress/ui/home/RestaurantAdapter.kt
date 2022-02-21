package kz.noxiq.chocoexpress.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.noxiq.chocoexpress.R
import kz.noxiq.chocoexpress.databinding.ViewHolderRestaurantBinding
import kz.noxiq.chocoexpress.domain.Restaurant

class RestaurantAdapter(
    private val onRestaurantClicked: (Long) -> Unit
) : ListAdapter<Restaurant, RestaurantViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding =
            ViewHolderRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RestaurantViewHolder(binding, onRestaurantClicked)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

private object DiffUtilCallback : DiffUtil.ItemCallback<Restaurant>() {

    override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
        return oldItem == newItem
    }
}