package com.example.retrofitxml

import retrofit2.http.GET
import com.example.retrofitxml.model.Feed
import retrofit2.Call

interface FeedAPI {
    @GET("videos/.rss")
    fun getFeed(): Call<Feed>


}

