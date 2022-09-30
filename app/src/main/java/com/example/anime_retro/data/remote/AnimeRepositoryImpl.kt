package com.example.anime_retro.data.remote

import com.example.anime_retro.data.mapper.toDomain
import com.example.anime_retro.domain.IAnimeRepository
import com.example.anime_retro.domain.models.Anime
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val dataSource: NetworkDataSource
) : IAnimeRepository {
    override suspend fun getAllAnime(): List<Anime> {
        val response = dataSource.getAllAnime()
        return response?.map { it.toDomain() } ?: emptyList()
    }
}