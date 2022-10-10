package com.example.anime_retro.data

import com.example.anime_retro.data.remote.Quotes1API
import com.example.anime_retro.data.remote.models.QuotesResponse1
import javax.inject.Inject

class NetworkDataSource1 @Inject constructor(
    private val api: Quotes1API
) {

    suspend fun getAllQuotes(): QuotesResponse1? {
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