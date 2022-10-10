package com.example.anime_retro.data.remote

import com.example.anime_retro.data.remote.models.QuotesResponse1
import retrofit2.Response
import retrofit2.http.GET

interface Quotes1API {

    @GET("quotes")
    suspend fun getAllQuotes(): Response<QuotesResponse1>
}