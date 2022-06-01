package kz.noxiq.chocoexpress.ui.home.menu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.noxiq.chocoexpress.databinding.ViewHolderRestaurantImageBinding
import kz.noxiq.chocoexpress.ui.home.menu.adapter.ImageViewHolder

class SliderViewPageAdapter(private val imageUrls: List<String>) :
    RecyclerView.Adapter<ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ViewHolderRestaurantImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(imageUrls[position])
    }

    override fun getItemCount(): Int = imageUrls.size


}