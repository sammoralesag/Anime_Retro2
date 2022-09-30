package com.example.anime_retro.data.remote

import com.example.anime_retro.data.remote.models.AnimeResponse
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val api: AnimeAPI
) {

    suspend fun getAllAnime(): AnimeResponse? {
        return try {
            val response = api.getAllAnime()
            if (response.isSuccessful) {
                response.body()
            } else
                null
        } catch (e: Exception) {
            null
        }
    }
}