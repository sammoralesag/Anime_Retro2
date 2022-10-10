package com.example.anime_retro.domain

import com.example.anime_retro.domain.models.Quotes


interface IQuotesRepository {
    suspend fun getAllQuotes(): List<Quotes>
}