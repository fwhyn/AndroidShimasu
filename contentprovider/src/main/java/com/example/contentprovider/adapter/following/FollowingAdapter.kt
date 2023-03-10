package com.example.contentprovider.adapter.following

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contentprovider.data.remote.responses.following.FollowingResponse
import com.example.contentprovider.databinding.ItemFollowRowBinding


class FollowingAdapter(
    val item: ArrayList<FollowingResponse>,
    private val listener: (FollowingResponse) -> Unit
) : RecyclerView.Adapter<FollowingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingViewHolder =
        FollowingViewHolder(
            ItemFollowRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: FollowingViewHolder, position: Int) =
        holder.bindList(item[position], listener)

    override fun getItemCount(): Int = item.size

    fun setData(items: List<FollowingResponse>) {
        item.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }
}