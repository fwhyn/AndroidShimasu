package com.example.contentprovider.adapter.followers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contentprovider.data.remote.responses.follower.FollowersResponse
import com.example.contentprovider.databinding.ItemFollowRowBinding


class FollowerAdapter(
    val item: ArrayList<FollowersResponse>,
    private val listener: (FollowersResponse) -> Unit
) :
    RecyclerView.Adapter<FollowerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        return FollowerViewHolder(
            ItemFollowRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.bindList(item[position], listener)
    }

    override fun getItemCount(): Int = item.size

    fun setData(items: List<FollowersResponse>) {
        item.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }
}