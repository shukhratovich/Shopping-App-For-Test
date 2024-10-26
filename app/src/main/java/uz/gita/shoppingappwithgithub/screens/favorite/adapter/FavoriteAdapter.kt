package uz.gita.shoppingappwithgithub.screens.favorite.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.gita.shoppingappwithgithub.R
import uz.gita.shoppingappwithgithub.databinding.ItemProductBinding
import uz.gita.shoppingappwithgithub.source.entity.ProductEntity

class FavoriteAdapter(private var products: ArrayList<ProductEntity>) :
    RecyclerView.Adapter<FavoriteAdapter.ProductsVh>() {
    var itemClickListener: ((ProductEntity) -> Unit)? = null
    var itemFavoriteClickListener: ((ProductEntity) -> Boolean)? = null

    inner class ProductsVh(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.itemProduct.setOnClickListener {
                itemClickListener?.invoke(products[adapterPosition])
            }
            binding.ivFavorite.setOnClickListener {
                if (itemFavoriteClickListener?.invoke(products[adapterPosition])!!) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsVh {
        return ProductsVh(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductsVh, position: Int) {
        holder.bind(products[position])
    }

    fun submitList(list: ArrayList<ProductEntity>) {
        products.clear()
        products.addAll(list)
        notifyDataSetChanged()
    }
}