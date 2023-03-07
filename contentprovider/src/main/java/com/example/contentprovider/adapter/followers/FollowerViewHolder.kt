package com.example.contentprovider.adapter.followers

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.contentprovider.data.remote.responses.follower.FollowersResponse
import com.example.contentprovider.databinding.ItemFollowRowBinding


class FollowerViewHolder(private val binding: ItemFollowRowBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindList(data: FollowersResponse, listener: (FollowersResponse) -> Unit) {
        binding.apply {
            ivFollower.load(data.avatarUrl) {
                transformations(CircleCropTransformation())
            }
            tvUsernameFollower.text = data.login
            root.setOnClickListener { listener(data) }
        }
    }
}