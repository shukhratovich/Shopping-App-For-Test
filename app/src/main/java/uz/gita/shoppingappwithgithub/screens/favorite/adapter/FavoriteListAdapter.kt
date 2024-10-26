package uz.gita.shoppingappwithgithub.screens.favorite.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.shoppingappwithgithub.R
import uz.gita.shoppingappwithgithub.databinding.ItemProductBinding
import uz.gita.shoppingappwithgithub.source.entity.ProductEntity


class FavoriteListAdapter :
    ListAdapter<ProductEntity, FavoriteListAdapter.ProductsVh>(ProductDiffUtil) {
    var changeFavouriteStateListener: ((ProductEntity) -> Boolean)? = null
    private var itemProductListener: ((ProductEntity) -> Unit)? = null

    object ProductDiffUtil : DiffUtil.ItemCallback<ProductEntity>() {
        override fun areItemsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
            return oldItem == newItem
        }

    }

    inner class ProductsVh(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.itemProduct.setOnClickListener {
                itemProductListener?.invoke(getItem(adapterPosition))
            }
            binding.ivFavorite.setOnClickListener {
                if (changeFavouriteStateListener?.invoke(getItem(adapterPosition))!!) {
                    binding.ivFavorite.setImageResource(R.drawable.ic_favorite)
                } else {
                    binding.ivFavorite.setImageResource(R.drawable.ic_not_favorite)
                }
            }
            binding.ivBasket.setOnClickListener { }
        }

        @SuppressLint("SetTextI18n")
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsVh =
        ProductsVh(ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ProductsVh, position: Int) {
        holder.bind(getItem(position))
    }
}