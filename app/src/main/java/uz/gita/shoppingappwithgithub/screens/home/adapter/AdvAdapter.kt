package uz.gita.shoppingappwithgithub.screens.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.gita.shoppingappwithgithub.R
import uz.gita.shoppingappwithgithub.databinding.ItemAdvertisingBinding
import uz.gita.shoppingappwithgithub.source.data.AdvData

class AdvAdapter : RecyclerView.Adapter<AdvAdapter.AdvVh>() {
    private val list: ArrayList<AdvData> = arrayListOf(
        AdvData(R.drawable.adv_1),
        AdvData(R.drawable.adv_2),
        AdvData(R.drawable.adv_3),
        AdvData(R.drawable.adv_4),
    )

    inner class AdvVh(private val binding: ItemAdvertisingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.ivAdv.setImageResource(list[adapterPosition].image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvVh {
        return AdvVh(
            ItemAdvertisingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AdvVh, position: Int) {
        holder.bind()
    }
}