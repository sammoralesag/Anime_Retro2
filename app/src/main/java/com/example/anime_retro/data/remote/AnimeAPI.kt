package com.example.anime_retro.data.remote

import com.example.anime_retro.data.remote.models.NewQuotesResponse
import retrofit2.Response
import retrofit2.http.GET

interface AnimeAPI {

    @GET("quotes?query=science")
    suspend fun getAllQuotes(): Response<NewQuotesResponse>
}