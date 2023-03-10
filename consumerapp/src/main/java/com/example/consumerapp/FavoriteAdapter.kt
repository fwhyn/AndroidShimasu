package com.example.consumerapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.consumerapp.databinding.ItemFavoriteRowBinding


class FavoriteAdapter(
    private val item: ArrayList<FavoriteUser>,
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
        holder.bindList(item[position])
    }

    override fun getItemCount(): Int = item.size

    fun setData(items: List<FavoriteUser>) {
        item.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }
}