package kz.noxiq.chocoexpress.ui.home.stash

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.noxiq.chocoexpress.databinding.ViewHolderOrderBinding
import kz.noxiq.chocoexpress.domain.menu.model.Product

class StashOrderAdapter : ListAdapter<Product, StashOrderViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StashOrderViewHolder {
        val binding =
            ViewHolderOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return StashOrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StashOrderViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }


    private object DiffUtilCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }
}

