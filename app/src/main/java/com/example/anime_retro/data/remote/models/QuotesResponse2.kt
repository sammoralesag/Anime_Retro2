package com.example.anime_retro.data.remote.models


import com.google.gson.annotations.SerializedName

data class QuotesResponse2(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("lastItemIndex")
    val lastItemIndex: Int?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<Result?>?,
    @SerializedName("totalCount")
    val totalCount: Int?,
    @SerializedName("totalPages")
    val totalPages: Int?
)