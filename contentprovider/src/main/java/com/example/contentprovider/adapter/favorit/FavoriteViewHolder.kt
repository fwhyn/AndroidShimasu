package com.example.contentprovider.adapter.favorit

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.contentprovider.data.remote.responses.search.Item
import com.example.contentprovider.databinding.ItemFavoriteRowBinding


class FavoriteViewHolder(val binding: ItemFavoriteRowBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindList(userFavs: Item, listener: (Item) -> Unit) {
        binding.tvUsernameFav.text = userFavs.login
        binding.ivUserFav.load(userFavs.avatarUrl) {
            transformations(CircleCropTransformation())
        }
        binding.rootView.setOnClickListener {
            listener.invoke(userFavs)
        }
    }
}