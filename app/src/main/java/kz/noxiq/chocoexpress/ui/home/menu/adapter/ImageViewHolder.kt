package kz.noxiq.chocoexpress.ui.home.menu.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.noxiq.chocoexpress.databinding.ViewHolderRestaurantImageBinding

class ImageViewHolder(private val binding: ViewHolderRestaurantImageBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(data: String) {
        Glide.with(binding.root)
            .load(data)
            .into(binding.sliderImageView)
    }
}