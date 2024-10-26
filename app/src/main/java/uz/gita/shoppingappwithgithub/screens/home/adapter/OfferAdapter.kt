package uz.gita.shoppingappwithgithub.screens.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.gita.shoppingappwithgithub.R
import uz.gita.shoppingappwithgithub.databinding.ItemOfferBinding
import uz.gita.shoppingappwithgithub.source.data.OfferData

class OfferAdapter : RecyclerView.Adapter<OfferAdapter.AdvVh>() {
    private val list: ArrayList<OfferData> = arrayListOf(
        OfferData(R.drawable.foyda, "Foyda"),
        OfferData(R.drawable.artel, "Artel Savdosi"),
        OfferData(R.drawable.evos, "2+1"),
        OfferData(R.drawable.uzum, "Tugatish"),
        OfferData(R.drawable.kuzgi, "Kuzgi kiyimlar"),
        OfferData(R.drawable.wedding, "To`y mavsumi"),
        OfferData(R.drawable.artel, "Katta savdo"),
        OfferData(R.drawable.adv_1, "Siz uchun"),
    )

    inner class AdvVh(private val binding: ItemOfferBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.ivOffer.setImageResource(list[adapterPosition].image)
            binding.tvOfferName.text = list[adapterPosition].name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvVh {
        return AdvVh(
            ItemOfferBinding.inflate(
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