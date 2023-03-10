package com.example.contentprovider.adapter.favorit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contentprovider.data.remote.responses.search.Item
import com.example.contentprovider.databinding.ItemFavoriteRowBinding


class FavoriteAdapter(
    val item: ArrayList<Item>,
    private val listener: (Item) -> Unit
) :
    RecyclerView.Adapter<FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(
            ItemFavoriteRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bindList(item[position], listener)
    }

    override fun getItemCount(): Int = item.size

    fun setData(items: List<Item>) {
        item.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }
}