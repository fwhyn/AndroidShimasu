package com.example.contentprovider.data.remote.responses.search


import com.example.contentprovider.data.remote.responses.search.Item
import com.google.gson.annotations.SerializedName

data class SearchUserResponse(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("total_count")
    val totalCount: Int
)