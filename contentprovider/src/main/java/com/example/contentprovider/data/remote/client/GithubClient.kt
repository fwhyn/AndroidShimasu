package com.example.contentprovider.data.remote.client

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.example.contentprovider.data.remote.responses.detail.DetailResponse
import com.example.contentprovider.data.remote.responses.follower.FollowersResponses
import com.example.contentprovider.data.remote.responses.following.FollowingResponses
import com.example.contentprovider.data.remote.responses.search.SearchUserResponse


interface GithubClient {
    @GET("search/users")
    suspend fun getSearchUser(@Query("q") query: String): Response<SearchUserResponse>

    @GET("users/{username}")
    suspend fun getDetailUser(@Path("username") userName: String): Response<DetailResponse>

    @GET("users/{username}/followers")
    suspend fun getUserFollowers(@Path("username") userName: String): Response<FollowersResponses>

    @GET("users/{username}/following")
    suspend fun getUserFollowing(@Path("username") userName: String): Response<FollowingResponses>

}