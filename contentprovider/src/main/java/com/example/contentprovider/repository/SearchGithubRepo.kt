package com.example.contentprovider.repository

import retrofit2.Response
import com.example.contentprovider.data.remote.client.GithubClient
import com.example.contentprovider.data.remote.responses.detail.DetailResponse
import com.example.contentprovider.data.remote.responses.follower.FollowersResponses
import com.example.contentprovider.data.remote.responses.following.FollowingResponses
import com.example.contentprovider.data.remote.responses.search.SearchUserResponse
import javax.inject.Inject


class SearchGithubRepo @Inject constructor(
    private val apiService: GithubClient
) {
    suspend fun getSearchUser(query: String): Response<SearchUserResponse> =
        apiService.getSearchUser(query)

    suspend fun getDetailUser(username: String): Response<DetailResponse> =
        apiService.getDetailUser(username)

    suspend fun getFollower(username: String): Response<FollowersResponses> =
        apiService.getUserFollowers(username)

    suspend fun getFollowing(username: String): Response<FollowingResponses> =
        apiService.getUserFollowing(username)
}