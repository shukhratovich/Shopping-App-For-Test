package uz.gita.shoppingappwithgithub.screens.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.shoppingappwithgithub.R
import uz.gita.shoppingappwithgithub.databinding.ItemBasketBinding
import uz.gita.shoppingappwithgithub.source.entity.ProductEntity

class BasketListAdapter : ListAdapter<ProductEntity, BasketListAdapter.BasketVH>(ProductDiffUtil) {
    var favouriteStateListener: ((ProductEntity) -> Boolean)? = null

    object ProductDiffUtil : DiffUtil.ItemCallback<ProductEntity>() {
        override fun areItemsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
            return oldItem == newItem
        }

    }

    inner class BasketVH(private val binding: ItemBasketBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.ivFavorite.setOnClickListener {
                if (favouriteStateListener?.invoke(getItem(adapterPosition))!!) {
                    binding.ivFavorite.setImageResource(R.drawable.ic_favorite)
                } else {
                    binding.ivFavorite.setImageResource(R.drawable.ic_not_favorite)
                }
            }
        }

        fun bind(productEntity: ProductEntity) {
            binding.ivProduct.setImageResource(productEntity.image)
            binding.tvProductName.text = productEntity.name
            if (productEntity.isFavourite) {
                binding.ivFavorite.setImageResource(R.drawable.ic_favorite)
            } else {
                binding.ivFavorite.setImageResource(R.drawable.ic_not_favorite)
            }
            binding.tvNewPrice.text = productEntity.newPrice
            binding.tvOldPrice.text = productEntity.oldPrice
            binding.tvMoneyName.text = "so`m"
            binding.tvSaleName.text = "Katta bozor"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketVH = BasketVH(
        ItemBasketBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: BasketVH, position: Int) {
        holder.bind(getItem(position))
    }
}