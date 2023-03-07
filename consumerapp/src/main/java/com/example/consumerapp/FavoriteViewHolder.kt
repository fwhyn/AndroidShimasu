package com.example.consumerapp

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.consumerapp.FavoriteUser
import com.example.consumerapp.databinding.ItemFavoriteRowBinding


class FavoriteViewHolder(private val binding: ItemFavoriteRowBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindList(userFavs: FavoriteUser) {
        binding.tvUsernameFav.text = userFavs.username
        binding.ivUserFav.load(userFavs.avatarUrl) {
            transformations(CircleCropTransformation())
        }
    }
}