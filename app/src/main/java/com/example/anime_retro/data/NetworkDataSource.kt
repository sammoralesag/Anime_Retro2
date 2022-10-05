package com.example.anime_retro.data

import com.example.anime_retro.data.remote.AnimeAPI
import com.example.anime_retro.data.remote.models.NewQuotesResponse
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val api: AnimeAPI
) {

    suspend fun getAllQuotes(): NewQuotesResponse? {
        return try {
            val response = api.getAllQuotes()
            if (response.isSuccessful) {
                response.body()
            } else
                null
        } catch (e: Exception) {
            null
        }
    }
}