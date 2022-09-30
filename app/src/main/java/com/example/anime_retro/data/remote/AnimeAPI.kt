package com.example.anime_retro.data.remote

import com.example.anime_retro.data.remote.models.AnimeResponse
import retrofit2.Response
import retrofit2.http.GET

interface AnimeAPI {

    @GET("quotes")
    suspend fun getAllAnime(): Response<AnimeResponse>
}