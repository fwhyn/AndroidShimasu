package com.example.contentprovider.adapter.following

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.contentprovider.data.remote.responses.following.FollowingResponse
import com.example.contentprovider.databinding.ItemFollowRowBinding


class FollowingViewHolder(private val binding: ItemFollowRowBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindList(data: FollowingResponse, listener: (FollowingResponse) -> Unit) {
        binding.apply {
            ivFollower.load(data.avatarUrl) {
                transformations(CircleCropTransformation())
            }
            tvUsernameFollower.text = data.login
            root.setOnClickListener { listener(data) }
        }

    }
}