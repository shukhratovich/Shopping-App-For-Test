package uz.gita.shoppingappwithgithub.screens.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.gita.shoppingappwithgithub.databinding.ItemAdvertisingBinding

class AdvAdapter : RecyclerView.Adapter<AdvAdapter.AdvVh>() {

    inner class AdvVh(private val binding: ItemAdvertisingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvVh {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: AdvVh, position: Int) {
        TODO("Not yet implemented")
    }
}