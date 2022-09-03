package me.shockyng.mybalance.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import me.shockyng.mybalance.databinding.HomeItemBinding
import me.shockyng.mybalance.databinding.TransactionItemBinding
import me.shockyng.mybalance.ui.home.HomeItem

class TransactionItemAdapter(
    private val homeOptions: LiveData<List<HomeItem>>
) : RecyclerView.Adapter<TransactionItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(TransactionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(homeOptions.value!![position])
    }

    override fun getItemCount(): Int = homeOptions.value?.size ?: 4

    class ViewHolder(private val binding: TransactionItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(homeItem: HomeItem) = with(itemView) {
//            binding.imageFavoriteRepo.setImageDrawable(resources.getDrawable(homeItem.icon!!))
//            binding.textRepoDescription.text = homeItem.name
        }
    }
}