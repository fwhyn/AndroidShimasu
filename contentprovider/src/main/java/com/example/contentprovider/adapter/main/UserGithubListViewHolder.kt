package com.example.contentprovider.adapter.main

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.contentprovider.data.remote.responses.search.Item
import com.example.contentprovider.databinding.ItemUserRowBinding

class UserGithubListViewHolder(private val binding: ItemUserRowBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindList(data: Item, listener: (Item) -> Unit) {
        binding.tvUsername.text = data.login
        binding.ivUser.load(data.avatarUrl) {
            this.transformations(CircleCropTransformation())
        }
        binding.root.setOnClickListener { listener(data) }
    }
}