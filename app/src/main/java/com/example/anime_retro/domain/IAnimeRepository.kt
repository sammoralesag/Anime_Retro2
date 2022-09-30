package com.example.anime_retro.domain

import com.example.anime_retro.domain.models.Anime

interface IAnimeRepository {
    suspend fun getAllAnime(): List<Anime>
}