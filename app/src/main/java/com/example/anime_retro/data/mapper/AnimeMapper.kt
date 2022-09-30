package com.example.anime_retro.data.mapper

import com.example.anime_retro.data.remote.models.AnimeResponseItem
import com.example.anime_retro.domain.models.Anime

fun AnimeResponseItem.toDomain(): Anime = Anime(
    anime = this.anime,
    character = this.character,
    quote = this.quote
)