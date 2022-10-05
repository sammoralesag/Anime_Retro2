package com.example.anime_retro.data.mapper

import com.example.anime_retro.domain.models.Anime

fun com.example.anime_retro.data.remote.models.Result.toDomain(): Anime = Anime(
    anime = this.authorId ?: "",
    character = this.author ?: "",
    quote = this.content ?: ""
)