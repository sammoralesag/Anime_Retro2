package com.example.anime_retro.data.remote

import com.example.anime_retro.data.NetworkDataSource
import com.example.anime_retro.data.mapper.toDomain
import com.example.anime_retro.domain.IAnimeRepository
import com.example.anime_retro.domain.models.Anime
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val dataSource: NetworkDataSource
) : IAnimeRepository {
    override suspend fun getAllAnime(): List<Anime> {
        val response = dataSource.getAllQuotes()
        val result = response?.results
        return result?.map { it!!.toDomain() } ?: emptyList()
    }
}