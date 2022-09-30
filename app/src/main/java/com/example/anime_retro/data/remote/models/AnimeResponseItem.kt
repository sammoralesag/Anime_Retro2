package com.example.anime_retro.data.remote.models


import com.google.gson.annotations.SerializedName

data class AnimeResponseItem(
    @SerializedName("anime")
    val anime: String,
    @SerializedName("character")
    val character: String,
    @SerializedName("quote")
    val quote: String
)